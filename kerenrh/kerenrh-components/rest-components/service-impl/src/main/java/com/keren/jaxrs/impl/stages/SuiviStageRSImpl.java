
package com.keren.jaxrs.impl.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.stages.SuiviStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.SuiviStageRS;
import com.keren.model.stages.Stage;
import com.keren.model.stages.SuiviStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/suivistage")
public class SuiviStageRSImpl
    extends AbstractGenericService<SuiviStage, Long>
    implements SuiviStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "SuiviStageManagerImpl", interf = SuiviStageManagerRemote.class)
    protected SuiviStageManagerRemote manager;

    public SuiviStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SuiviStage, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new SuiviStage(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Terminer", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'suivistage','method':'termine'}");
   	        workbtn.setStates(new String[]{"etabli"});
//   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'mission','method':'annule'}");
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
            SuiviStage entity = manager.find("id", (Long) id);
            
            if(!entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Le SuiviStage est déjà en cours de traitement");
            }//end if(!entity.getState().equalsIgnoreCase("etabli")){

            super.processBeforeDelete(id);
        }

	@Override
	public SuiviStage termine(HttpHeaders headers, SuiviStage entity) {
		// TODO Auto-generated method stub
		if(entity.getDdebutr()==null){
			throw new KerenExecption("La date de début effective est obligatoire");
		}else if(entity.getDfinr()==null){
			throw new KerenExecption("La date de fin effective est obligatoire");
		}
		return manager.termine(entity);
	}

}
