
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewBulletinPaieHelper;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Nov 30 09:20:28 WAT 2018
 * 
 */
public interface ViewBulletinPaieHelperDAO
    extends GenericDAO<ViewBulletinPaieHelper, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewBulletinPaieHelperDAO";

}
