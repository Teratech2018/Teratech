
package com.kerenedu.jaxrs.impl.report;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewDltPaiementRS;
import com.kerenedu.model.report.ViewDltPaiement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 11:37:46 WAT 2018
 * 
 */
@Path("/viewdltpaiement")
public class ViewDltPaiementRSImpl
    extends AbstractGenericService<ViewDltPaiement, Long>
    implements ViewDltPaiementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewDltPaiementManagerImpl", interf = ViewDltPaiementManagerRemote.class)
    protected ViewDltPaiementManagerRemote manager;

    public ViewDltPaiementRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewDltPaiement(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewDltPaiement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
