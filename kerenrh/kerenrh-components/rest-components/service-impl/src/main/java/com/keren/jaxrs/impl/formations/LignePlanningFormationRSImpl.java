
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.LignePlanningFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.LignePlanningFormationRS;
import com.keren.model.formations.LignePlanningFormation;
import com.keren.model.formations.PlanningFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/ligneplanningformation")
public class LignePlanningFormationRSImpl
    extends AbstractGenericService<LignePlanningFormation, Long>
    implements LignePlanningFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LignePlanningFormationManagerImpl", interf = LignePlanningFormationManagerRemote.class)
    protected LignePlanningFormationManagerRemote manager;

    public LignePlanningFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LignePlanningFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		MetaData meta = null;
   		try {
   			meta = MetaDataUtil.getMetaData(new LignePlanningFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Démarrer", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'ligneplanningformation','method':'demarre'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'besionformation','method':'rejete'}");
//   	        workbtn.setStates(new String[]{"etabli"});
//   	        workbtn.setPattern("btn btn-danger");
//   	        meta.getHeader().add(workbtn);   
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
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		LignePlanningFormation entity = manager.find("id", (Long) id);
		if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Calendrier de Formation en cours de traitement");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(LignePlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDdebut()==null){
			throw new KerenExecption("La date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La date de fin est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de formation concerné est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(LignePlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDdebut()==null){
			throw new KerenExecption("La date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La date de fin est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de formation concerné est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public LignePlanningFormation demarrer(HttpHeaders headers, LignePlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDdebut()==null){
			throw new KerenExecption("La date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La date de fin est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de formation concerné est obligatoire");
		}else if(entity.getCibles()==null||entity.getCibles().isEmpty()){
			throw new KerenExecption("Veuillez fournir la liste des apprenants");
		}
		return manager.demaree(entity);
	}

}
