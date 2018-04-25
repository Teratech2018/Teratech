
package com.megatimgroup.smsgw.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.smsgw.model.referentiel.Order;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Oct 23 15:06:49 WAT 2017
 * 
 */
public interface OrderManager
    extends GenericManager<Order, Long>
{

    public final static String SERVICE_NAME = "OrderManager";

}
