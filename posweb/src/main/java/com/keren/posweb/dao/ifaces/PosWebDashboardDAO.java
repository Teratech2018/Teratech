
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.PosWebDashboard;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Sep 05 10:52:24 GMT+01:00 2018
 * 
 */
public interface PosWebDashboardDAO
    extends GenericDAO<PosWebDashboard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PosWebDashboardDAO";

}
