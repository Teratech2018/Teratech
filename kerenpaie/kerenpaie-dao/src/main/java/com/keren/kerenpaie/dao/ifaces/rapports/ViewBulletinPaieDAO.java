
package com.keren.kerenpaie.dao.ifaces.rapports;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
public interface ViewBulletinPaieDAO
    extends GenericDAO<ViewBulletinPaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewBulletinPaieDAO";

}
