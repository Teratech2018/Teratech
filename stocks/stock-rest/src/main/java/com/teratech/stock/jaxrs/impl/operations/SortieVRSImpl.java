
package com.teratech.stock.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.stock.core.ifaces.operations.SortieVManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.SortieVRS;
import com.teratech.stock.model.operations.SortieV;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 22 09:04:45 GMT+01:00 2018
 * 
 */
@Path("/sortiev")
public class SortieVRSImpl
    extends AbstractGenericService<SortieV, Long>
    implements SortieVRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "SortieVManagerImpl", interf = SortieVManagerRemote.class)
    protected SortieVManagerRemote manager;

    public SortieVRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SortieV, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

}
