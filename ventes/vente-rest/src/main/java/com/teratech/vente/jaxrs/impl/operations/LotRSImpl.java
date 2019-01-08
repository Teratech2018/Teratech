
package com.teratech.vente.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.vente.core.ifaces.operations.LotManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.LotRS;
import com.teratech.vente.model.operations.Lot;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jan 04 08:13:40 WAT 2019
 * 
 */
@Path("/lot")
public class LotRSImpl
    extends AbstractGenericService<Lot, Long>
    implements LotRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "LotManagerImpl", interf = LotManagerRemote.class)
    protected LotManagerRemote manager;

    public LotRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Lot, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

}
