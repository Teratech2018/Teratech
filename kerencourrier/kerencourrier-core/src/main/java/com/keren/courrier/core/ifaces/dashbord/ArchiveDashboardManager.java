
package com.keren.courrier.core.ifaces.dashbord;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.dashbord.ArchiveDashboard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Sep 03 12:16:16 WAT 2018
 * 
 */
public interface ArchiveDashboardManager
    extends GenericManager<ArchiveDashboard, Long>
{

    public final static String SERVICE_NAME = "ArchiveDashboardManager";

}
