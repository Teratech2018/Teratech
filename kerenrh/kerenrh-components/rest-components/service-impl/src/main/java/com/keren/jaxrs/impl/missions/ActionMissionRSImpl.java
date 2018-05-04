
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.ActionMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.ActionMissionRS;
import com.keren.model.missions.ActionMission;
import com.keren.model.missions.ResultatMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/actionmission")
public class ActionMissionRSImpl
    extends AbstractGenericService<ActionMission, Long>
    implements ActionMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ActionMissionManagerImpl", interf = ActionMissionManagerRemote.class)
    protected ActionMissionManagerRemote manager;

    public ActionMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ActionMission, Long> getManager() {
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
                    meta = MetaDataUtil.getMetaData(new ActionMission(), new HashMap<String, MetaData>()
                    , new ArrayList<String>());
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
    protected void processBeforeUpdate(ActionMission entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("L'intitulé est obligatoire");
        }else if(entity.getIndicateur()==null){
            throw new KerenExecption("L'indicateur  est obligatoire");
        }/*else if(entity.getObjectif()==null||entity.getObjectif().trim().isEmpty()){
            throw new KerenExecption("L'objectif est obligatoire");
        }else if(entity.getResultat()==null||entity.getResultat().trim().isEmpty()){
            throw new KerenExecption("La Resultat est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(ActionMission entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("L'intitulé est obligatoire");
        }else if(entity.getIndicateur()==null){
            throw new KerenExecption("L'indicateur  est obligatoire");
        }/*else if(entity.getObjectif()==null||entity.getObjectif().trim().isEmpty()){
            throw new KerenExecption("L'objectif est obligatoire");
        }else if(entity.getResultat()==null||entity.getResultat().trim().isEmpty()){
            throw new KerenExecption("Le resultat est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
    
    @Override
    public ActionMission delete(Long id) {
        
        //Initialisation
        ActionMission data = null;
        ActionMission result = null;
        
        try{
        
            data = super.delete(id);
            result = new ActionMission(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }    
}
