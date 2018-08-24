
package com.core.website;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Aug 22 13:33:15 GMT+01:00 2018
 * 
 */
@Path("/websitemodule")
public class WebSiteModuleRSImpl
    extends AbstractGenericService<WebSiteModule, Long>
    implements WebSiteModuleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "WebSiteModuleManagerImpl", interf = WebSiteModuleManagerRemote.class)
    protected WebSiteModuleManagerRemote manager;
    
    @Manager(application = "kerencore", name = "WebSiteComponentManagerImpl", interf = WebSiteComponentManagerRemote.class)
    protected WebSiteComponentManagerRemote templatemanager;

    public WebSiteModuleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<WebSiteModule, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

    @Override
    public WebSiteComponent getWebSiteIndex(HttpHeaders headers, String website) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("website.code", website);
        container.addEq("indexPage", Boolean.TRUE);
        List<WebSiteComponent> templates = templatemanager.filter(container.getPredicats(), null, null, 0, -1);
        if(templates!=null && !templates.isEmpty()){
            WebSiteComponent template = templates.get(0);
            return new WebSiteComponent(template);
        }//end if(templates!=null && !templates.isEmpty()){
        return null;
    }

    @Override
    public WebSiteComponent getWebSiteTemplate(HttpHeaders headers, String website, String fragment) {
        //To change body of generated methods, choose Tools | Templates.
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("website.code", website);
        container.addEq("code", fragment);
        List<WebSiteComponent> templates = templatemanager.filter(container.getPredicats(), null, null, 0, -1);
        if(templates!=null && !templates.isEmpty()){
            WebSiteComponent template = templates.get(0);
            return new WebSiteComponent(template);
        }//end if(templates!=null && !templates.isEmpty()){
        return null;
    }

}
