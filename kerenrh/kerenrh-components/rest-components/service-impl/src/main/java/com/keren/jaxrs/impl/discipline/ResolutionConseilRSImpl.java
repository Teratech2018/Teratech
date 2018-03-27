
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.ResolutionConseilManagerRemote;
import com.keren.jaxrs.ifaces.discipline.ResolutionConseilRS;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.ResolutionConseil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Feb 16 11:11:48 GMT+01:00 2018
 * 
 */
@Path("/resolutionconseil")
public class ResolutionConseilRSImpl
    extends AbstractGenericService<ResolutionConseil, Long>
    implements ResolutionConseilRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ResolutionConseilManagerImpl", interf = ResolutionConseilManagerRemote.class)
    protected ResolutionConseilManagerRemote manager;

    public ResolutionConseilRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ResolutionConseil, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new ResolutionConseil(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
	}

}
