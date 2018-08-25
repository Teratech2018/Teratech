
package com.keren.portailweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.portailweb.model.PortailWebDashboard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Aug 25 07:54:03 GMT+01:00 2018
 * 
 */
public interface PortailWebDashboardManager
    extends GenericManager<PortailWebDashboard, Long>
{

    public final static String SERVICE_NAME = "PortailWebDashboardManager";

}
