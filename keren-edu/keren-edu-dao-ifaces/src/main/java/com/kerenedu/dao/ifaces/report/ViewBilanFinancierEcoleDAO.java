
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewBilanFinancierEcole;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jun 19 15:43:31 WAT 2018
 * 
 */
public interface ViewBilanFinancierEcoleDAO
    extends GenericDAO<ViewBilanFinancierEcole, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewBilanFinancierEcoleDAO";

}
