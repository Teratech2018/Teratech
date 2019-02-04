
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewEtatPret;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 24 15:14:54 WAT 2019
 * 
 */
public interface ViewEtatPretDAO
    extends GenericDAO<ViewEtatPret, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewEtatPretDAO";

}
