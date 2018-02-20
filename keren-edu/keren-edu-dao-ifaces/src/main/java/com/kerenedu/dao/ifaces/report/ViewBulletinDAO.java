
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewBulletin;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 15:02:24 CET 2018
 * 
 */
public interface ViewBulletinDAO
    extends GenericDAO<ViewBulletin, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewBulletinDAO";

}
