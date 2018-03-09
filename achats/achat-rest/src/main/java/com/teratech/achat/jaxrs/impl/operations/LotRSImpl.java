
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.operations.LotManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LotRS;
import com.teratech.achat.model.operations.Lot;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 01 15:49:45 GMT+01:00 2018
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
    @Manager(application = "teratechachat", name = "LotManagerImpl", interf = LotManagerRemote.class)
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
        return ("teratechachat");
    }

}
