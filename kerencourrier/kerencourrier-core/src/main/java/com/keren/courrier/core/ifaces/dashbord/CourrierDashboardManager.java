
package com.keren.courrier.core.ifaces.dashbord;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.dashbord.CourrierDashboard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 19 13:57:23 GMT+01:00 2018
 * 
 */
public interface CourrierDashboardManager
    extends GenericManager<CourrierDashboard, Long>
{

    public final static String SERVICE_NAME = "CourrierDashboardManager";

}
