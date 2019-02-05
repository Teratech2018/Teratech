
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Sep 10 15:39:11 WAT 2018
 * 
 */
@Path("/periodepaie")
public class PeriodePaieRSImpl
    extends AbstractGenericService<PeriodePaie, Long>
    implements PeriodePaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
    protected AcompteManagerRemote manageracompte;
    
    @Manager(application = "kereneducation", name = "RemboursementPretManagerImpl", interf = RemboursementPretManagerRemote.class)
    protected RemboursementPretManagerRemote managerrembour;
    
    @Manager(application = "kereneducation", name = "DemandePretManagerImpl", interf = DemandePretManagerRemote.class)
    protected DemandePretManagerRemote managerpret;

    public PeriodePaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			
   		  MetaData meta = MetaDataUtil.getMetaData(new PeriodePaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
          MetaColumn workbtn = new MetaColumn("button", "work1", "Reouvrir une période", false, "workflow", null);
          workbtn.setValue("{'model':'kereneducation','entity':'periodepaie','method':'reouvir'}");
          workbtn.setStates(new String[]{"ferme"});
          workbtn.setPattern("btn btn-success");
          meta.getHeader().add(workbtn);
          MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
          meta.getHeader().add(stautsbar);
   			return meta;
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

	@Override
	public PeriodePaie delete(HttpHeaders headers, Long id) {
		PeriodePaie periode = manager.find("id", id);
		if (periode.getState().equals("ourvet")) {
			throw new KerenExecption("impossible de supprimer la periode est déja ourvete ou fermée");
		}
		return super.delete(headers, id);
	}

	@Override
	protected void processBeforeUpdate(PeriodePaie entity) {
		 if(entity.getState().equals("ourvet")){
             throw new KerenExecption("impossible de modifier la periode est déja ourvete ou fermée");
		 }
		super.processBeforeUpdate(entity);
	}

	@Override
	public PeriodePaie reouvrir(HttpHeaders headers, PeriodePaie entity) {
		// valide payement acompte echeance de la periode
		RestrictionsContainer container = RestrictionsContainer.newInstance();

		if (entity != null) {
			container.addGe("date",entity.getDdebut());
			container.addLe("date",entity.getDfin());
		} // end if(classe!=null)
		container.addNotEq("state", "annule");	
		List<RemboursementPret> remlist = managerrembour.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(remlist!=null&&!remlist.isEmpty()){
			for(RemboursementPret rem : remlist){
				rem.setState("confirme");
				managerrembour.update(rem.getId(), rem);
				// update pret
				DemandePret ddepret = rem.getDemande();
				ddepret.setState("encours");
				double liquide = ddepret.getMontantRem()-rem.getMontant();
				ddepret.setMontantRem(liquide);
				managerpret.update(ddepret.getId(), ddepret);
			}
		}
		System.out.println("PeriodePaieCloseRSImpl.save() update remboursement ok ==========");
		container = RestrictionsContainer.newInstance();
		if (entity != null) {
			container.addGe("effet",entity.getDdebut());
			container.addLe("effet",entity.getDfin());
		} // end if(classe!=null)
		container.addNotEq("state", "annule");
		List<Acompte> acomptelist= manageracompte.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(acomptelist!=null&&!acomptelist.isEmpty()){
			for(Acompte acompte : acomptelist){
				acompte.setState("confirme");
				manageracompte.update(acompte.getId(), acompte);
			}
		}
		System.out.println("PeriodePaieCloseRSImpl.save() update acompte ok ==========");

		// ferme période
		entity.setState("ouvert");
		manager.update(entity.getId(), entity);
		return null;
	}
    
    


}
