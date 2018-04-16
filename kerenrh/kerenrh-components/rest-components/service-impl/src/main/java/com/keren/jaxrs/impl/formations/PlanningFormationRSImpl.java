
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.PlanningFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.PlanningFormationRS;
import com.keren.model.formations.BesionFormation;
import com.keren.model.formations.PlanningFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/planningformation")
public class PlanningFormationRSImpl
    extends AbstractGenericService<PlanningFormation, Long>
    implements PlanningFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "PlanningFormationManagerImpl", interf = PlanningFormationManagerRemote.class)
    protected PlanningFormationManagerRemote manager;

    public PlanningFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PlanningFormation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new PlanningFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'planningformation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
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
		PlanningFormation entity = manager.find("id", (Long) id);
		if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Planning de formation en cours de traitement");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(PlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getBesion()==null){
			throw new KerenExecption("Le besion concerné est obligatoire");
		}else if(entity.getPeriode()==null||entity.getPeriode().trim().isEmpty()){
			throw new KerenExecption("La periode est obligatoire");
		}		
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(PlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getBesion()==null){
			throw new KerenExecption("Le besion concerné est obligatoire");
		}else if(entity.getPeriode()==null||entity.getPeriode().trim().isEmpty()){
			throw new KerenExecption("La periode est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public PlanningFormation valide(HttpHeaders headers, PlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
			throw new KerenExecption("L'intitulé du planning est obligatoire");
		}else if(entity.getBesion()==null){
			throw new KerenExecption("Le besion concerné est obligatoire");
		}else if(entity.getPeriode()==null||entity.getPeriode().trim().isEmpty()){
			throw new KerenExecption("La periode est obligatoire");
		}else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
			throw new KerenExecption("Veuillez saisir le Calendrier de formation");
		}
		return manager.valide(entity);
	}

}
