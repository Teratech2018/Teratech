
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewBilanServiceEleve;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 14 15:47:40 WAT 2018
 * 
 */
public interface ViewBilanServiceEleveDAO
    extends GenericDAO<ViewBilanServiceEleve, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewBilanServiceEleveDAO";

}
