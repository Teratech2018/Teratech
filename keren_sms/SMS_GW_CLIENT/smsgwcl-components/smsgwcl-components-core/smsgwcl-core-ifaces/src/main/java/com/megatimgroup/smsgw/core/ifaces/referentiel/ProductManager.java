
package com.megatimgroup.smsgw.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.smsgw.model.referentiel.Product;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Oct 23 15:06:47 WAT 2017
 * 
 */
public interface ProductManager
    extends GenericManager<Product, Long>
{

    public final static String SERVICE_NAME = "com.megatimgroup.smsgw.core.impl.referentiel.ProductManagerImpl";

}
