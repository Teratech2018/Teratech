
package com.keren.courrier.dao.ifaces.dashbord;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.dashbord.ArchiveDashboard;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Sep 03 12:16:16 WAT 2018
 * 
 */
public interface ArchiveDashboardDAO
    extends GenericDAO<ArchiveDashboard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ArchiveDashboardDAO";

}
