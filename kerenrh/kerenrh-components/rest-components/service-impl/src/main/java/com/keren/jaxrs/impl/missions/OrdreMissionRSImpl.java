
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.OrdreMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.OrdreMissionRS;
import com.keren.model.missions.Mission;
import com.keren.model.missions.OrdreMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.Date;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/ordremission")
public class OrdreMissionRSImpl
    extends AbstractGenericService<OrdreMission, Long>
    implements OrdreMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "OrdreMissionManagerImpl", interf = OrdreMissionManagerRemote.class)
    protected OrdreMissionManagerRemote manager;

    public OrdreMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<OrdreMission, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new OrdreMission(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'ordremission','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'ordremission','method':'annule'}");
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
            OrdreMission entity = manager.find("id", (Long)id);
            if(!entity.getState().trim().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Cette Ordre de mission à déjà fait l'objet d'un traitement");
            }//end if(!entity.getState().trim().equalsIgnoreCase("etabli")){
            super.processBeforeDelete(id); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void processBeforeUpdate(OrdreMission entity) {
            if(entity.getMotif()==null||entity.getMotif().trim().isEmpty()){
            	throw new KerenExecption("Le motif de la mission est obligatoire");
            }else if(entity.getVille()==null){
            	throw new KerenExecption("La Ville de destination de la mission est obligatoire");
            }else if(entity.getVille()==null){
            	throw new KerenExecption("L'employé concerné est obligatoire");
            }else if(entity.getVille()==null){
            	throw new KerenExecption("Le Type de mission est obligatoire");
            }
           
            super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void processBeforeSave(OrdreMission entity) {
        	 if(entity.getMotif()==null||entity.getMotif().trim().isEmpty()){
             	throw new KerenExecption("Le motif de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("La Ville de destination de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("L'employé concerné est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("Le Type de mission est obligatoire");
             }
            super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public OrdreMission valide(HttpHeaders headers, OrdreMission entity) {            
            // TODO Auto-generated method stub
        	 if(entity.getMotif()==null||entity.getMotif().trim().isEmpty()){
             	throw new KerenExecption("Le motif de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("La Ville de destination de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("L'employé concerné est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("Le Type de mission est obligatoire");
             }else if(entity.getDdepart()==null){
            	 throw new KerenExecption("La Date de départ en mission est obligatoire");
             }else if(entity.getDretour()==null){
            	 throw new KerenExecption("La Date de retour de mission est obligatoire");
             }
            return manager.valide(entity);
        }

        @Override
        public OrdreMission annule(HttpHeaders headers, OrdreMission entity) {
                 // TODO Auto-generated method stub
        	if(entity.getMotif()==null||entity.getMotif().trim().isEmpty()){
             	throw new KerenExecption("Le motif de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("La Ville de destination de la mission est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("L'employé concerné est obligatoire");
             }else if(entity.getVille()==null){
             	throw new KerenExecption("Le Type de mission est obligatoire");
             }else if(entity.getDdepart()==null){
            	 throw new KerenExecption("La Date de départ en mission est obligatoire");
             }else if(entity.getDretour()==null){
            	 throw new KerenExecption("La Date de retour de mission est obligatoire");
             }else if(entity.getState().equalsIgnoreCase("etabli")){
            	 throw new KerenExecption("L'ordre de mission n'a fait l'object d'aucune validation");
             }else if(!entity.getState().equalsIgnoreCase("valide")){
            	 throw new KerenExecption("L'ordre de mission est déjà traité");
             }
             return manager.annule(entity);
        }

}
