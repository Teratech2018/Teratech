
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
@Path("/typeabscence")
public class TypeAbscenceRSImpl
    extends AbstractGenericService<TypeAbscence, Long>
    implements TypeAbscenceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "TypeAbscenceManagerImpl", interf = TypeAbscenceManagerRemote.class)
    protected TypeAbscenceManagerRemote manager;

    public TypeAbscenceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TypeAbscence, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new TypeAbscence(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
  	}

}
