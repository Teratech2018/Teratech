
package com.teratech.gmao.core.ifaces.preventif;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.preventif.MaintenancePreventive;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 21:57:15 GMT+01:00 2018
 * 
 */
public interface MaintenancePreventiveManager
    extends GenericManager<MaintenancePreventive, Long>
{

    public final static String SERVICE_NAME = "MaintenancePreventiveManager";

}
