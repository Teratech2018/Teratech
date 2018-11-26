
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewNotematiere;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface ViewNotematiereDAO
    extends GenericDAO<ViewNotematiere, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewNotematiereDAO";

}
