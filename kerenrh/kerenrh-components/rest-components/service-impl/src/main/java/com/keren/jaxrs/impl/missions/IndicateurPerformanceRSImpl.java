
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerRemote;
import com.keren.jaxrs.ifaces.missions.IndicateurPerformanceRS;
import com.keren.model.missions.ActionMission;
import com.keren.model.missions.IndicateurPerformance;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/indicateurperformance")
public class IndicateurPerformanceRSImpl
    extends AbstractGenericService<IndicateurPerformance, Long>
    implements IndicateurPerformanceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "IndicateurPerformanceManagerImpl", interf = IndicateurPerformanceManagerRemote.class)
    protected IndicateurPerformanceManagerRemote manager;

    public IndicateurPerformanceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<IndicateurPerformance, Long> getManager() {
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
                    meta = MetaDataUtil.getMetaData(new IndicateurPerformance(), new HashMap<String, MetaData>()
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
    protected void processBeforeUpdate(IndicateurPerformance entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'intitulé est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("Le Type d'indicateur est obligatoire");
            }
            super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(IndicateurPerformance entity) {
        
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'intitulé est obligatoire");
            }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
                throw new KerenExecption("Le Type d'indicateur est obligatoire");
            }
            
            super.processBeforeSave(entity);
    }
    
    @Override
    public IndicateurPerformance delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        IndicateurPerformance data = null;
        IndicateurPerformance result = null;

        try{

            data = super.delete(headers,id);
            result = new IndicateurPerformance(data);

        }catch(Exception e){

            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }

        return result; //To change body of generated methods, choose Tools | Templates.
    }
}