
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Devise;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 13 14:45:37 GMT+01:00 2018
 * 
 */
public interface DeviseManager
    extends GenericManager<Devise, Long>
{

    public final static String SERVICE_NAME = "DeviseManager";

}
