
package com.keren.courrier.dao.ifaces.dashbord;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.dashbord.CourrierDashboard;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 19 13:57:22 GMT+01:00 2018
 * 
 */
public interface CourrierDashboardDAO
    extends GenericDAO<CourrierDashboard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierDashboardDAO";

}
