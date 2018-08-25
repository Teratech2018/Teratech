
package com.keren.portailweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.portailweb.model.PortailWebDashboard;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Aug 25 07:54:03 GMT+01:00 2018
 * 
 */
public interface PortailWebDashboardDAO
    extends GenericDAO<PortailWebDashboard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PortailWebDashboardDAO";

}
