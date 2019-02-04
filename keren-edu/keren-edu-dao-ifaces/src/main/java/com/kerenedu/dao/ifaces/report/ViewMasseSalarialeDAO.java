
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewMasseSalariale;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sun Jan 27 16:15:10 WAT 2019
 * 
 */
public interface ViewMasseSalarialeDAO
    extends GenericDAO<ViewMasseSalariale, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewMasseSalarialeDAO";

}
