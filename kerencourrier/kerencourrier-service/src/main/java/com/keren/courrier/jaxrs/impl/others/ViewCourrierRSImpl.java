
package com.keren.courrier.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.others.ViewCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.ViewCourrierRS;
import com.keren.courrier.model.others.ViewCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Aug 01 14:46:37 GMT+01:00 2018
 * 
 */
@Path("/viewcourrier")
public class ViewCourrierRSImpl
    extends AbstractGenericService<ViewCourrier, Long>
    implements ViewCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "ViewCourrierManagerImpl", interf = ViewCourrierManagerRemote.class)
    protected ViewCourrierManagerRemote manager;

    public ViewCourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
