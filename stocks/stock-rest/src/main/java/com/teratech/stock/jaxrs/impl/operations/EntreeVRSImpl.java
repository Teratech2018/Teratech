
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.stock.core.ifaces.operations.EntreeVManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.EntreeVRS;
import com.teratech.stock.model.operations.EntreeV;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 22 09:04:45 GMT+01:00 2018
 * 
 */
@Path("/entreev")
public class EntreeVRSImpl
    extends AbstractGenericService<EntreeV, Long>
    implements EntreeVRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "EntreeVManagerImpl", interf = EntreeVManagerRemote.class)
    protected EntreeVManagerRemote manager;

    public EntreeVRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EntreeV, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

}
