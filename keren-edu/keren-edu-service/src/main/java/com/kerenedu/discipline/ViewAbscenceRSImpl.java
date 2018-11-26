
package com.kerenedu.discipline;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Nov 26 15:39:58 WAT 2018
 * 
 */
@Path("/viewabscence")
public class ViewAbscenceRSImpl
    extends AbstractGenericService<ViewAbscence, Long>
    implements ViewAbscenceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewAbscenceManagerImpl", interf = ViewAbscenceManagerRemote.class)
    protected ViewAbscenceManagerRemote manager;

    public ViewAbscenceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewAbscence, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
