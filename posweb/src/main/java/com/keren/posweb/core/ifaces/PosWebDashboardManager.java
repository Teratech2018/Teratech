
package com.keren.posweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.model.PosWebDashboard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Sep 05 10:52:24 GMT+01:00 2018
 * 
 */
public interface PosWebDashboardManager
    extends GenericManager<PosWebDashboard, Long>
{

    public final static String SERVICE_NAME = "PosWebDashboardManager";

}
