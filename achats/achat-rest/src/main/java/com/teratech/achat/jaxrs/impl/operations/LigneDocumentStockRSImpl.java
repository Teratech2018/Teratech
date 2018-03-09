
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.operations.LigneDocumentStockManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LigneDocumentStockRS;
import com.teratech.achat.model.operations.LigneDocumentStock;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 01 15:22:49 GMT+01:00 2018
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
    @Manager(application = "teratechachat", name = "LigneDocumentStockManagerImpl", interf = LigneDocumentStockManagerRemote.class)
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
        return ("teratechachat");
    }

}
