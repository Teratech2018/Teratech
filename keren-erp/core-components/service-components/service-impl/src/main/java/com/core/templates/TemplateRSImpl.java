
package com.core.templates;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Dec 06 11:57:28 WAT 2018
 * 
 */
@Path("/template")
public class TemplateRSImpl
    extends AbstractGenericService<Template, Long>
    implements TemplateRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "TemplateManagerImpl", interf = TemplateManagerRemote.class)
    protected TemplateManagerRemote manager;

    public TemplateRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Template, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

    /**
     *Return the template with the field name name
     * @param headers
     * @param name
     * @return
     */
    @Override
    public Template getTemplate(HttpHeaders headers, String name) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("code", name);
        List<Template> templates = manager.filter(container.getPredicats(), null, null, 0, -1);
        if(templates!=null && !templates.isEmpty()){
            Template result = templates.get(0);
            return new Template(result);
        }//end if(templates!=null && !templates.isEmpty()){        
        return null;
    }

}
