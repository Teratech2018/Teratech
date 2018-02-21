
package com.teratech.stock.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.base.Emplacement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 13:10:17 GMT+01:00 2018
 * 
 */
public interface EmplacementManager
    extends GenericManager<Emplacement, Long>
{

    public final static String SERVICE_NAME = "EmplacementManager";

}
