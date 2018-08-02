
package com.kerenedu.dashboard;

import java.util.Date;
import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jun 22 10:15:30 WAT 2018
 * 
 */
public interface ViewDashboardManager
    extends GenericManager<ViewDashboard, Long>
{

    public final static String SERVICE_NAME = "ViewDashboardManager";
    
    public List<ViewDashboard> getdashboarddata();
    
    public void scheduleEventManager(Date initialExpiration, long duration);

}
