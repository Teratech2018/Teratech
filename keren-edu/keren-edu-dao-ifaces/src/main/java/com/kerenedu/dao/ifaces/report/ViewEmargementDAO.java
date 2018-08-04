
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewEmargement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 23 15:41:27 WAT 2018
 * 
 */
public interface ViewEmargementDAO
    extends GenericDAO<ViewEmargement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewEmargementDAO";

}
