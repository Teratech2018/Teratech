
package com.kerenedu.dashboard;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jun 22 10:15:29 WAT 2018
 * 
 */
public interface ViewDashboardDAO
    extends GenericDAO<ViewDashboard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewDashboardDAO";

}
