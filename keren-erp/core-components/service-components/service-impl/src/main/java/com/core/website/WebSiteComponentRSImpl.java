
package com.core.website;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Aug 22 20:59:04 GMT+01:00 2018
 * 
 */
@Path("/websitecomponent")
public class WebSiteComponentRSImpl
    extends AbstractGenericService<WebSiteComponent, Long>
    implements WebSiteComponentRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "WebSiteComponentManagerImpl", interf = WebSiteComponentManagerRemote.class)
    protected WebSiteComponentManagerRemote manager;

    public WebSiteComponentRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<WebSiteComponent, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

}
