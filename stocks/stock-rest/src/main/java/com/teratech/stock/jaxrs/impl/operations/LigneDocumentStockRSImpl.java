
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.operations.LigneDocumentStockManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.LigneDocumentStockRS;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.operations.LigneDocumentStock;
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
@Path("/lignedocumentstock")
public class LigneDocumentStockRSImpl
    extends AbstractGenericService<LigneDocumentStock, Long>
    implements LigneDocumentStockRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "LigneDocumentStockManagerImpl", interf = LigneDocumentStockManagerRemote.class)
    protected LigneDocumentStockManagerRemote manager;

    public LigneDocumentStockRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneDocumentStock, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new LigneDocumentStock(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }

}
