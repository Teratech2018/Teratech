
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 14:27:02 WAT 2018
 * 
 */
@Path("/periodepaieclose")
public class PeriodePaieCloseRSImpl
    extends AbstractGenericService<PeriodePaieClose, Long>
    implements PeriodePaieCloseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "PeriodePaieCloseManagerImpl", interf = PeriodePaieCloseManagerRemote.class)
    protected PeriodePaieCloseManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote managerperiode;
    
    @Manager(application = "kereneducation", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
    protected AcompteManagerRemote manageracompte;
    
    @Manager(application = "kereneducation", name = "RemboursementPretManagerImpl", interf = RemboursementPretManagerRemote.class)
    protected RemboursementPretManagerRemote managerrembour;
    
    @Manager(application = "kereneducation", name = "DemandePretManagerImpl", interf = DemandePretManagerRemote.class)
    protected DemandePretManagerRemote managerpret;
    
    

    public PeriodePaieCloseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaieClose, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    
	@Override
	public PeriodePaieClose save(@Context HttpHeaders headers ,PeriodePaieClose entity) {
		// TODO Auto-generated method stub
		entity.getPeriode().setState("ferme");
		PeriodePaie periode = entity.getPeriode();
		
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(id, TypeCacheMemory.PERIODE, entity.getPeriode());
		
		// valide payement acompte echeance de la periode
		RestrictionsContainer container = RestrictionsContainer.newInstance();

		if (periode != null) {
			container.addGe("date",periode.getDdebut());
			container.addLe("date",periode.getDfin());
		} // end if(classe!=null)
		container.addNotEq("state", "annule");	
		List<RemboursementPret> remlist = managerrembour.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(remlist!=null&&!remlist.isEmpty()){
			for(RemboursementPret rem : remlist){
				rem.setState("paye");
				managerrembour.update(rem.getId(), rem);
				// update pret
				DemandePret ddepret = rem.getDemande();
				ddepret.setState("encours");
				double liquide = ddepret.getMontantRem()+rem.getMontant();
				ddepret.setMontantRem(liquide);
				managerpret.update(ddepret.getId(), ddepret);
			}
		}
		System.out.println("PeriodePaieCloseRSImpl.save() update remboursement ok ==========");
		container = RestrictionsContainer.newInstance();
		if (periode != null) {
			container.addGe("effet",periode.getDdebut());
			container.addLe("effet",periode.getDfin());
		} // end if(classe!=null)
		container.addNotEq("state", "annule");
		List<Acompte> acomptelist= manageracompte.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(acomptelist!=null&&!acomptelist.isEmpty()){
			for(Acompte acompte : acomptelist){
				acompte.setState("paye");
				manageracompte.update(acompte.getId(), acompte);
			}
		}
		System.out.println("PeriodePaieCloseRSImpl.save() update acompte ok ==========");

		// ferme période
		managerperiode.update(entity.getPeriode().getId(), entity.getPeriode());
		
		return entity;
	}
	
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new PeriodePaieClose(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    
    @Override
    public PeriodePaieClose delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        PeriodePaieClose entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
