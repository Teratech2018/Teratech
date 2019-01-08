
package com.teratech.vente.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.comptabilite.JournalComptable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:36 WAT 2019
 * 
 */
public interface JournalComptableManager
    extends GenericManager<JournalComptable, Long>
{

    public final static String SERVICE_NAME = "JournalComptableManager";

}
