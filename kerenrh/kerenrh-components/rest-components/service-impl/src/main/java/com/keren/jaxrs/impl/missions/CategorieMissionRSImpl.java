
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.CategorieMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.CategorieMissionRS;
import com.keren.model.missions.CategorieMission;
import com.keren.model.missions.ResultatMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/categoriemission")
public class CategorieMissionRSImpl
    extends AbstractGenericService<CategorieMission, Long>
    implements CategorieMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CategorieMissionManagerImpl", interf = CategorieMissionManagerRemote.class)
    protected CategorieMissionManagerRemote manager;

    public CategorieMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CategorieMission, Long> getManager() {
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
                    meta = MetaDataUtil.getMetaData(new CategorieMission(), new HashMap<String, MetaData>()
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
    protected void processBeforeUpdate(CategorieMission entity) {

        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("La Intitulé est obligatoire");
        }
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(CategorieMission entity) {

        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("La Intitulé est obligatoire");
        }
        super.processBeforeSave(entity);
    }
    
    @Override
    public CategorieMission delete(Long id) {
        
        //Initialisation
        CategorieMission data = null;
        CategorieMission result = null;
        
        try{
        
            data = super.delete(id);
            result = new CategorieMission(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }        
}
