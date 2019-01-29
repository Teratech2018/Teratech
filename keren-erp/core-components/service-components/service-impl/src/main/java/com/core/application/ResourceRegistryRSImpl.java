
package com.core.application;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 22 08:53:32 WAT 2019
 * 
 */
@Path("/resourceregistry")
public class ResourceRegistryRSImpl
    extends AbstractGenericService<ResourceRegistry, Long>
    implements ResourceRegistryRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "ResourceRegistryManagerImpl", interf = ResourceRegistryManagerRemote.class)
    protected ResourceRegistryManagerRemote manager;

    public ResourceRegistryRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ResourceRegistry, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

}
