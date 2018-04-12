
package com.keren.jaxrs.impl.missions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
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

}
