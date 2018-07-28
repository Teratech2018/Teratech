
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.MissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.MissionRS;
import com.keren.model.missions.Mission;
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
@Path("/mission")
public class MissionRSImpl
    extends AbstractGenericService<Mission, Long>
    implements MissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "MissionManagerImpl", interf = MissionManagerRemote.class)
    protected MissionManagerRemote manager;

    public MissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Mission, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Mission(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'mission','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'mission','method':'annule'}");
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
        Mission entity = manager.find("id", (Long)id);
        if(!entity.getState().trim().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Cette Mission à déjà fait l'objet d'un traitement");
        }//end if(!entity.getState().trim().equalsIgnoreCase("etabli")){
        super.processBeforeDelete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(Mission entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference de la Mission est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le Type de la Mission est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
        	throw new KerenExecption("L'Intitulé de la Mission est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Mission entity) {
    	if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference de la Mission est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le Type de la Mission est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
        	throw new KerenExecption("L'Intitulé de la Mission est obligatoire");
        }
    	entity.setState("etabli");
        entity.setDcreation(new Date());
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public Mission valide(HttpHeaders headers, Mission entity) {
            // TODO Auto-generated method stub
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Mission est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("Le Type de la Mission est obligatoire");
            }else if(entity.getDdebut()==null){
                throw new KerenExecption("Le Date début de la Mission est obligatoire"); 
             }else if(entity.getDfin()==null){
                throw new KerenExecption("Le Date de fin de la Mission est obligatoire"); 
             }else if(entity.getDvalidation()==null){
                throw new KerenExecption("Le Date de Validation de la Mission est obligatoire"); 
             }else if(entity.getDapprob()==null){
                 throw new KerenExecption("Le Date d'Approbation de la Mission est obligatoire"); 
              }else if(entity.getMissions()==null||entity.getMissions().isEmpty()){
                 throw new KerenExecption("Veuillez saisir au moins un ordre de mission"); 
             } 
            return manager.valide(entity);
    }

    @Override
    public Mission annule(HttpHeaders headers, Mission entity) {
            // TODO Auto-generated method stub
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Mission est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("Le Type de la Mission est obligatoire");
            }else if(entity.getDdebut()==null){
                throw new KerenExecption("Le Date début de la Mission est obligatoire"); 
             }else if(entity.getDfin()==null){
                throw new KerenExecption("Le Date de fin de la Mission est obligatoire"); 
             }else if(entity.getDvalidation()==null){
                throw new KerenExecption("Le Date de Validation de la Mission est obligatoire"); 
             }else if(!entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("La mission n' fait l'objet d'aucune validation"); 
             }else if(!entity.getState().equalsIgnoreCase("valide")){
                 throw new KerenExecption("Impossible d'annuler une mission en cours de traitement"); 
              }   
            return manager.annule(entity);
    }
    
    @Override
    public Mission delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        Mission data = null;
        Mission result = null;

        try{

            data = super.delete(headers,id);
            result = new Mission(data);

        }catch(Exception e){

            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }

        return result; //To change body of generated methods, choose Tools | Templates.
    }
}
