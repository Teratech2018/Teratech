
package com.core.application;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 29 13:33:04 WAT 2019
 * 
 */
@Path("/serviceregistry")
public class ServiceRegistryRSImpl
    extends AbstractGenericService<ServiceRegistry, Long>
    implements ServiceRegistryRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "ServiceRegistryManagerImpl", interf = ServiceRegistryManagerRemote.class)
    protected ServiceRegistryManagerRemote manager;

    public ServiceRegistryRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ServiceRegistry, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

}
