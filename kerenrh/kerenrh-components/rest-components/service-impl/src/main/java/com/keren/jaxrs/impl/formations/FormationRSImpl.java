
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.FormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.FormationRS;
import com.keren.model.formations.Formation;
import com.keren.model.formations.SeanceFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 16:28:46 GMT+01:00 2018
 * 
 */
@Path("/formation")
public class FormationRSImpl 
    extends AbstractGenericService<Formation, Long>
    implements FormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FormationManagerImpl", interf = FormationManagerRemote.class)
    protected FormationManagerRemote manager;

    public FormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Formation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Formation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'formation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'formation','method':'annule'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
   	        meta.getHeader().add(workbtn);   
   	        workbtn = new MetaColumn("button", "work1", "Cloturer la Formation", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenrh','entity':'formation','method':'cloture'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-primary");
	        meta.getHeader().add(workbtn);   
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
		Formation entity = manager.find("id", (Long) id);
		if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("La Formation est en cours de traitement");
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference de la formation est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de la formation est obligatoire");
		}else if(entity.getTheme()==null){
			throw new KerenExecption("Le Thème de la formation est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference de la formation est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de la formation est obligatoire");
		}else if(entity.getTheme()==null){
			throw new KerenExecption("Le Thème de la formation est obligatoire");
		}else if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Formation en cours de traitement");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Formation valide(HttpHeaders headers, Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference de la formation est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de la formation est obligatoire");
		}else if(entity.getTheme()==null){
			throw new KerenExecption("Le Thème de la formation est obligatoire");
		}else if(entity.getSeances()==null||entity.getSeances().isEmpty()){
			throw new KerenExecption("Veuillez fournir les séances de formations");
		}
		valideSeances(entity,false);
		return manager.valide(entity);
	}	

	@Override
	public Formation annule(HttpHeaders headers, Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference de la formation est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de la formation est obligatoire");
		}else if(entity.getTheme()==null){
			throw new KerenExecption("Le Thème de la formation est obligatoire");
		}else if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("La formation à déjà fait l'objet d'un traitement");
		}
		return manager.annule(entity);
	}
	
			
	/**
	 * 
	 * @param entity
	 * @return
	 */
	private Boolean valideSeances(Formation entity,boolean cloture){
		for(SeanceFormation seance:entity.getSeances()){
			if(seance.getId()<=0){
				throw new KerenExecption("Veuillez enregistrer les modifications avant de procèder à la validation");
			}
			if(cloture){
				if(seance.getState().equalsIgnoreCase("etabli")){
					throw new KerenExecption("Verifiez que toute les Seances de formations sont traitées et Réessayer");
				}//end if(seance.getState().equalsIgnoreCase("etabli")){
			}//end if(cloture){
		}
		return true ;
	}

    @Override
    public Formation cloturer(HttpHeaders headers, Formation entity) {
        //To change body of generated methods, choose Tools | Templates.
    	if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference de la formation est obligatoire");
		}else if(entity.getModule()==null){
			throw new KerenExecption("Le module de la formation est obligatoire");
		}else if(entity.getTheme()==null){
			throw new KerenExecption("Le Thème de la formation est obligatoire");
		}else if(entity.getSeances()==null||entity.getSeances().isEmpty()){
			throw new KerenExecption("Veuillez fournir les séances de formations");
		}
		valideSeances(entity,true);
		return manager.cloture(entity);
    }

}
