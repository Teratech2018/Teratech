
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.operations.EntreeManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.EntreeRS;
import com.teratech.achat.model.operations.Entree;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 01 15:22:49 GMT+01:00 2018
 * 
 */
@Path("/entree")
public class EntreeRSImpl
    extends AbstractGenericService<Entree, Long>
    implements EntreeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "EntreeManagerImpl", interf = EntreeManagerRemote.class)
    protected EntreeManagerRemote manager;

    public EntreeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Entree, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

}
