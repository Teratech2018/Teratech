
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.stock.core.ifaces.operations.TransfertVManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.TransfertVRS;
import com.teratech.stock.model.operations.TransfertV;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 22 09:04:45 GMT+01:00 2018
 * 
 */
@Path("/transfertv")
public class TransfertVRSImpl
    extends AbstractGenericService<TransfertV, Long>
    implements TransfertVRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "TransfertVManagerImpl", interf = TransfertVManagerRemote.class)
    protected TransfertVManagerRemote manager;

    public TransfertVRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TransfertV, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

}
