
package com.kerenedu.personnel;

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
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
@Path("/emargementprofdetails")
public class EmargementProfDetailsRSImpl
    extends AbstractGenericService<EmargementProfDetails, Long>
    implements EmargementProfDetailsRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EmargementProfDetailsManagerImpl", interf = EmargementProfDetailsManagerRemote.class)
    protected EmargementProfDetailsManagerRemote manager;

    public EmargementProfDetailsRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EmargementProfDetails, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new EmargementProfDetails(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return null;
   	}


}
