
package com.keren.jaxrs.impl.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.stages.StageManagerRemote;
import com.keren.jaxrs.ifaces.stages.StageRS;
import com.keren.model.stages.BesionStage;
import com.keren.model.stages.Stage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/stage")
public class StageRSImpl
    extends AbstractGenericService<Stage, Long>
    implements StageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "StageManagerImpl", interf = StageManagerRemote.class)
    protected StageManagerRemote manager;

    public StageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Stage, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Stage(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'stage','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'stage','method':'annule'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
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
		Stage entity = manager.find("id", (Long) id);
		if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Le Stage est déjà en cours de traitement");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du stage est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de stage est obligatoire");
		}else if(entity.getType().trim().equals("0") && entity.getEcole()==null){
			throw new KerenExecption("L'Etablissement est obligatoire pour les stage Académique");
		}else if(entity.getDepartement()==null){
			throw new KerenExecption("La Structure d'affectation est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de début est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getEncadreur()==null){
			throw new KerenExecption("L'Encadreur Professionel est obligatoire");
		}
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du stage est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de stage est obligatoire");
		}else if(entity.getType().trim().equals("0") && entity.getEcole()==null){
			throw new KerenExecption("L'Etablissement est obligatoire pour les stage Académique");
		}else if(entity.getDepartement()==null){
			throw new KerenExecption("La Structure d'affectation est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de début est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getEncadreur()==null){
			throw new KerenExecption("L'Encadreur Professionel est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Stage valide(HttpHeaders headers, Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du stage est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de stage est obligatoire");
		}else if(entity.getType().trim().equals("0") && entity.getEcole()==null){
			throw new KerenExecption("L'Etablissement est obligatoire pour les stage Académique");
		}else if(entity.getDepartement()==null){
			throw new KerenExecption("La Structure d'affectation est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de début est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getEncadreur()==null){
			throw new KerenExecption("L'Encadreur Professionel est obligatoire");
		}
		return manager.valide(entity);
	}

	@Override
	public Stage annule(HttpHeaders headers, Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference du stage est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de stage est obligatoire");
		}else if(entity.getType().trim().equals("0") && entity.getEcole()==null){
			throw new KerenExecption("L'Etablissement est obligatoire pour les stage Académique");
		}else if(entity.getDepartement()==null){
			throw new KerenExecption("La Structure d'affectation est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de début est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getEncadreur()==null){
			throw new KerenExecption("L'Encadreur Professionel est obligatoire");
		}else if(entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("L'Annulation ne concerne que les Stages déjà validés");
		}else if(!entity.getState().equalsIgnoreCase("valide")){
			throw new KerenExecption("Seule les Stage Validé peut être annulé");
		}
		return manager.annule(entity);
	}

}
