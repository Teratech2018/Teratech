
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.reglement.Moratoire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Sep 07 17:10:43 WAT 2018
 * 
 */
@Path("/proffichepaie")
public class ProfFichePaieRSImpl
    extends AbstractGenericService<ProfFichePaie, Long>
    implements ProfFichePaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ProfFichePaieManagerImpl", interf = ProfFichePaieManagerRemote.class)
    protected ProfFichePaieManagerRemote manager;

    public ProfFichePaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ProfFichePaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ProfFichePaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

}
