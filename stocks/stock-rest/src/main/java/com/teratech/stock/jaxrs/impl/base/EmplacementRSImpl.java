
package com.teratech.stock.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.base.EmplacementManagerRemote;
import com.teratech.stock.jaxrs.ifaces.base.EmplacementRS;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 13:10:17 GMT+01:00 2018
 * 
 */
@Path("/emplacement")
public class EmplacementRSImpl
    extends AbstractGenericService<Emplacement, Long>
    implements EmplacementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "EmplacementManagerImpl", interf = EmplacementManagerRemote.class)
    protected EmplacementManagerRemote manager;

    public EmplacementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Emplacement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new Emplacement(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }

}
