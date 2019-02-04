
package com.kerenedu.jaxrs.impl.report;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.core.ifaces.report.ViewMasseSalarialeManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewMasseSalarialeRS;
import com.kerenedu.model.report.ViewMasseSalariale;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sun Jan 27 16:15:11 WAT 2019
 * 
 */
@Path("/viewmassesalariale")
public class ViewMasseSalarialeRSImpl
    extends AbstractGenericService<ViewMasseSalariale, Long>
    implements ViewMasseSalarialeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewMasseSalarialeManagerImpl", interf = ViewMasseSalarialeManagerRemote.class)
    protected ViewMasseSalarialeManagerRemote manager;

    public ViewMasseSalarialeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewMasseSalariale, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
