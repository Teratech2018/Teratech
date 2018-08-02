
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewAnniversaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewAnniversaireDAO
    extends GenericDAO<ViewAnniversaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewAnniversaireDAO";

}
