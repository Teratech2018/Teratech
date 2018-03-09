
package com.kerenedu.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 08 21:14:59 CET 2018
 * 
 */
@Path("/stagecl")
public class StageCLRSImpl
    extends AbstractGenericService<StageCL, Long>
    implements StageCLRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "StageCLManagerImpl", interf = StageCLManagerRemote.class)
    protected StageCLManagerRemote manager;

    public StageCLRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<StageCL, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new StageCL(),new HashMap<String, MetaData>()
   					, new ArrayList<String>());
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(e);
   		}
   	}

}
