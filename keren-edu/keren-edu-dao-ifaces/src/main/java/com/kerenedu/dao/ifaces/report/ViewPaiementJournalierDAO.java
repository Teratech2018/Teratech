
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewPaiementJournalier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Aug 04 14:08:53 WAT 2018
 * 
 */
public interface ViewPaiementJournalierDAO
    extends GenericDAO<ViewPaiementJournalier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewPaiementJournalierDAO";

}
