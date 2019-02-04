
package com.kerenedu.jaxrs.impl.report;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.core.ifaces.report.ViewEtatPretManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewEtatPretRS;
import com.kerenedu.model.report.ViewEtatPret;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Jan 24 15:14:55 WAT 2019
 * 
 */
@Path("/viewetatpret")
public class ViewEtatPretRSImpl
    extends AbstractGenericService<ViewEtatPret, Long>
    implements ViewEtatPretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewEtatPretManagerImpl", interf = ViewEtatPretManagerRemote.class)
    protected ViewEtatPretManagerRemote manager;

    public ViewEtatPretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewEtatPret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
