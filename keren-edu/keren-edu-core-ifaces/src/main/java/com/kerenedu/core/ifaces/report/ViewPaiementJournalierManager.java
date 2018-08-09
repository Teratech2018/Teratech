
package com.kerenedu.core.ifaces.report;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewPaiementJournalier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Aug 04 14:08:54 WAT 2018
 * 
 */
public interface ViewPaiementJournalierManager
    extends GenericManager<ViewPaiementJournalier, Long>
{

    public final static String SERVICE_NAME = "ViewPaiementJournalierManager";

}
