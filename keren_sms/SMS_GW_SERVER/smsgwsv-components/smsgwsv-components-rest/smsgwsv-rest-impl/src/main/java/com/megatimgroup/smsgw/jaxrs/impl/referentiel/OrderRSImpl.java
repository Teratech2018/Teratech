
package com.megatimgroup.smsgw.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.smsgw.core.ifaces.referentiel.OrderManagerRemote;
import com.megatimgroup.smsgw.jaxrs.ifaces.referentiel.OrderRS;
import com.megatimgroup.smsgw.model.referentiel.Order;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Oct 23 15:06:50 WAT 2017
 * 
 */
@Path("/order")
public class OrderRSImpl
    extends AbstractGenericService<Order, Long>
    implements OrderRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "smsgwsv-packaging-ear-1.0-SNAPSHOT", module = "smsgwsv-core-impl-1.0-SNAPSHOT", name = "OrderManagerImpl", interf = OrderManagerRemote.class)
    protected OrderManagerRemote manager;

    public OrderRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Order, Long> getManager() {
        return manager;
    }

}
