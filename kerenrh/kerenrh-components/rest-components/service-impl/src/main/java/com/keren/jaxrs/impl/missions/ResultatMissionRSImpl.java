
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.ResultatMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.ResultatMissionRS;
import com.keren.model.missions.ResultatMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 11:50:58 GMT+01:00 2018
 * 
 */
@Path("/resultatmission")
public class ResultatMissionRSImpl
    extends AbstractGenericService<ResultatMission, Long>
    implements ResultatMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ResultatMissionManagerImpl", interf = ResultatMissionManagerRemote.class)
    protected ResultatMissionManagerRemote manager;

    public ResultatMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ResultatMission, Long> getManager() {
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
                    meta = MetaDataUtil.getMetaData(new ResultatMission(), new HashMap<String, MetaData>()
                    , new ArrayList<String>());
                    MetaColumn workbtn = new MetaColumn("button", "work1", "Clôturer la Mission", false, "workflow", null);
           	        workbtn.setValue("{'model':'kerenrh','entity':'resultatmission','method':'cloture'}");
           	        workbtn.setStates(new String[]{"etabli"});
           	        workbtn.setPattern("btn btn-default");
           	        meta.getHeader().add(workbtn);           	        
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
    protected void processBeforeUpdate(ResultatMission entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le Libellé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le Type de mission est obligatoire");
        }else if(entity.getDcreation()==null){
            throw new KerenExecption("La Date de création est obligatoire");
        }
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(ResultatMission entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le Libellé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le Type de mission est obligatoire");
        }else if(entity.getDcreation()==null){
            throw new KerenExecption("La Date de création est obligatoire");
        }
        super.processBeforeSave(entity);
    }

    @Override
    public ResultatMission cloture(HttpHeaders headers, ResultatMission entity) {
            // TODO Auto-generated method stub
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
        throw new KerenExecption("La Reference est obligatoire");
    }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
        throw new KerenExecption("Le Libellé est obligatoire");
    }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
        throw new KerenExecption("Le Type de mission est obligatoire");
    }else if(entity.getDcreation()==null){
        throw new KerenExecption("La Date de création est obligatoire");
    }
            return manager.cloture(entity);
    }
    
    @Override
    public ResultatMission delete(Long id) {
        
        //Initialisation
        ResultatMission data = null;
        ResultatMission result = null;

        try{

            data = super.delete(id);
            result = new ResultatMission(data);

        }catch(Exception e){

            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }

        return result; //To change body of generated methods, choose Tools | Templates.
    }
}