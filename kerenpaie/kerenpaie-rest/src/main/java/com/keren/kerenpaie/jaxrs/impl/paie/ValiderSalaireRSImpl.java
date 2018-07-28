
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.ValiderSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ValiderSalaireRS;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Mar 13 16:31:05 GMT+01:00 2018
 * 
 */
@Path("/validersalaire")
public class ValiderSalaireRSImpl
    extends AbstractGenericService<ValiderSalaire, Long>
    implements ValiderSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ValiderSalaireManagerImpl", interf = ValiderSalaireManagerRemote.class)
    protected ValiderSalaireManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
    protected MoteurPaieManagerRemote moteurmanager;
    

    public ValiderSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ValiderSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		MetaData meta =null;
		try {
			meta = MetaDataUtil.getMetaData(new ValiderSalaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer le brouillard des salaires", false, "report", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'validersalaire','method':'imprimerbrouillard'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-success");
	        meta.getHeader().add(workbtn);   
//	        workbtn = new MetaColumn("button", "work1", "Refuser", false, "workflow", null);
//	        workbtn.setValue("{'model':'kerenpaie','entity':'remboursementpret','method':'refuse'}");
//	        workbtn.setStates(new String[]{"etabli"});
//	        workbtn.setPattern("btn btn-danger");
//	        meta.getHeader().add(workbtn);   
	        MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
	        meta.getHeader().add(stautsbar);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return meta;
	}

	@Override
	protected void processBeforeSave(ValiderSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getSociete()==null){
			throw new KerenExecption("La Structure concernée est obligatoire");
		}else if(entity.getPeriode()==null){
			throw new KerenExecption("La Periode concernée est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de paiement concernée est obligatoire");
		}else if(!DateHelper.between(entity.getDate(), entity.getPeriode().getDdebut(), entity.getPeriode().getDfin())){
			throw new KerenExecption("La Date de paiement concernée est obligatoire");
		}else if(entity.getPeriode()==null||entity.getPorte().trim().isEmpty()){
			throw new KerenExecption("La Portée de la validation est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	public ValiderSalaire save(@Context HttpHeaders headers , ValiderSalaire entity) {
		// TODO Auto-generated method stub
		processBeforeSave(entity);
		return moteurmanager.validerSalaire(entity);
	}
    
    

}
