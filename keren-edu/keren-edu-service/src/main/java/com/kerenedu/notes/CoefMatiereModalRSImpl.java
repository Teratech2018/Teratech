
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
@Path("/coefmatieremodal")
public class CoefMatiereModalRSImpl
    extends AbstractGenericService<CoefMatiereModal, Long>
    implements CoefMatiereModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "CoefMatiereManagerImpl", interf = CoefMatiereManagerRemote.class)
    protected CoefMatiereManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
    protected CoefMatiereDetailManagerRemote managercoefDlt;

    public CoefMatiereModalRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
	public GenericManager<CoefMatiereModal, Long> getManager() {
        return null;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new CoefMatiereModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
    

	
	  @Override
	    public CoefMatiereModal save(@Context HttpHeaders headers,CoefMatiereModal entity) {
		  CacheMemory.setFiliere(entity.getFiliere());
		  manager.generatecoefmat(entity);
	        return entity; 
	    }

	
	

}
