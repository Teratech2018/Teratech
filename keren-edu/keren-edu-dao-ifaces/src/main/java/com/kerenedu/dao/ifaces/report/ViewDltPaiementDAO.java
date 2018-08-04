
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewDltPaiement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jun 19 11:37:45 WAT 2018
 * 
 */
public interface ViewDltPaiementDAO
    extends GenericDAO<ViewDltPaiement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewDltPaiementDAO";

}
