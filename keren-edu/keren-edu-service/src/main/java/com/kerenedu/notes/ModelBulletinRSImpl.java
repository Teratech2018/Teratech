
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 24 13:23:41 WAT 2018
 * 
 */
@Path("/modelbulletin")
public class ModelBulletinRSImpl
    extends AbstractGenericService<ModelBulletin, Long>
    implements ModelBulletinRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ModelBulletinManagerImpl", interf = ModelBulletinManagerRemote.class)
    protected ModelBulletinManagerRemote manager;

    public ModelBulletinRSImpl() {
        super();
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  					
			MetaData meta =  MetaDataUtil.getMetaData(new ModelBulletin(), new HashMap<String, MetaData>(),new ArrayList<String>());
  			return meta;
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ModelBulletin, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
