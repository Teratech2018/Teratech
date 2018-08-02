
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewListeEleve;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jun 19 10:58:41 WAT 2018
 * 
 */
public interface ViewListeEleveDAO
    extends GenericDAO<ViewListeEleve, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewListeEleveDAO";

}
