
package com.teratech.vente.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.base.Devise;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:36 WAT 2019
 * 
 */
public interface DeviseManager
    extends GenericManager<Devise, Long>
{

    public final static String SERVICE_NAME = "DeviseManager";

}
