
package com.keren.jaxrs.impl.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.stages.BesionStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.BesionStageRS;
import com.keren.model.stages.BesionStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/besionstage")
public class BesionStageRSImpl
    extends AbstractGenericService<BesionStage, Long>
    implements BesionStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "BesionStageManagerImpl", interf = BesionStageManagerRemote.class)
    protected BesionStageManagerRemote manager;

    public BesionStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BesionStage, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new BesionStage(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'besionstage','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'besionstage','method':'annule'}");
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
            BesionStage entity = manager.find("id", (Long) id);
            
            // On teste l'etat
            if(!entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Ce besion de stage est en cours de traitement");
            }
            
            super.processBeforeDelete(id);
	}

        @Override
	public BesionStage delete(@Context HttpHeaders headers , Long id) {
            
            // TODO Auto-generated method stub
            BesionStage entity = manager.find("id", id);
            
            try{
                
                //on supprimme l'objet
                super.delete(headers,id);
                
            }catch(Exception ex){
                throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
            }
           
            return entity;
	}
        
	@Override
	protected void processBeforeSave(BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du besion est obligatoire");
		}else if(entity.getDemission()==null){
			throw new KerenExecption("La Date d'émission du besion est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getProfil()==null){
			throw new KerenExecption("Le Profil demandé est obligatoire");
		}else if(entity.getPlace()==null||entity.getPlace()==0){
			throw new KerenExecption("Le nombre de place désirées est obligation");
		}else if(entity.getDdebut().after(entity.getDfin())){
			throw new KerenExecption("La date de début est incorrecte");
		}
                
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du besion est obligatoire");
		}else if(entity.getDemission()==null){
			throw new KerenExecption("La Date d'émission du besion est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getProfil()==null){
			throw new KerenExecption("Le Profil demandé est obligatoire");
		}else if(entity.getPlace()==null||entity.getPlace()==0){
			throw new KerenExecption("Le nombre de place désirées est obligation");
		}else if(entity.getDdebut().after(entity.getDfin())){
			throw new KerenExecption("La date de début est incorrecte");
		}
                
		super.processBeforeUpdate(entity);
	}

	@Override
	public BesionStage valide(HttpHeaders headers, BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du besion est obligatoire");
		}else if(entity.getDemission()==null){
			throw new KerenExecption("La Date d'émission du besion est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getProfil()==null){
			throw new KerenExecption("Le Profil demandé est obligatoire");
		}else if(entity.getPlace()==null||entity.getPlace()==0){
			throw new KerenExecption("Le nombre de place désirées est obligation");
		}else if(entity.getDdebut().after(entity.getDfin())){
			throw new KerenExecption("La date de début est incorrecte");
		}
                
		return manager.valide(entity);
	}

	@Override
	public BesionStage annule(HttpHeaders headers, BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du besion est obligatoire");
		}else if(entity.getDemission()==null){
			throw new KerenExecption("La Date d'émission du besion est obligatoire");
		}else if(entity.getDdebut()==null){
			throw new KerenExecption("La Date de debut est obligatoire");
		}else if(entity.getDfin()==null){
			throw new KerenExecption("La Date de fin est obligatoire");
		}else if(entity.getProfil()==null){
			throw new KerenExecption("Le Profil demandé est obligatoire");
		}else if(entity.getPlace()==null||entity.getPlace()==0){
			throw new KerenExecption("Le nombre de place désirées est obligation");
		}else if(entity.getState().equalsIgnoreCase("encours")){
			throw new KerenExecption("Le Besion de stage est déjà en cours de traitement");
		}else if(entity.getState().equalsIgnoreCase("encours")
				||entity.getState().equalsIgnoreCase("traite")){
			throw new KerenExecption("Le Besion de stage est en cours ou déjà traité");
		}else if(entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Vous ne pouvez annulé que les Besions de stage Validé");
		}else if(entity.getDdebut().after(entity.getDfin())){
			throw new KerenExecption("La date de début est incorrecte");
		}
                
		return manager.annule(entity);
	}

}
