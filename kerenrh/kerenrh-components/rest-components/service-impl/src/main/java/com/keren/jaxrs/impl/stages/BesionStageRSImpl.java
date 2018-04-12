
package com.keren.jaxrs.impl.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.stages.BesionStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.BesionStageRS;
import com.keren.model.missions.Mission;
import com.keren.model.stages.BesionStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


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
	public BesionStage valide(HttpHeaders headers, BesionStage entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
