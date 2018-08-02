
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
@Path("/matierelot")
public class MatiereLotRSImpl
    extends AbstractGenericService<MatiereDlt, Long>
    implements MatiereLotRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "MatiereManagerImpl", interf = MatiereManagerRemote.class)
    protected MatiereManagerRemote manager;

    public MatiereLotRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<MatiereDlt, Long> getManager() {
        return null;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new MatiereDlt(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
  	}

	
    
    

}
