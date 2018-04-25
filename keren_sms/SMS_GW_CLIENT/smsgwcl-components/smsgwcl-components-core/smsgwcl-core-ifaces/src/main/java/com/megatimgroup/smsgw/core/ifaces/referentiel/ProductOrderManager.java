
package com.megatimgroup.smsgw.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Oct 23 15:06:47 WAT 2017
 * 
 */
public interface ProductOrderManager
    extends GenericManager<ProductOrder, Long>
{

    public final static String SERVICE_NAME = "com.megatimgroup.smsgw.core.impl.referentiel.ProductOrderManagerImpl";

}
