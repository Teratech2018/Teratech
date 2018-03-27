
package com.keren.kerenpaie.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.JournalComptable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Mar 21 14:00:16 GMT+01:00 2018
 * 
 */
public interface JournalComptableManager
    extends GenericManager<JournalComptable, Long>
{

    public final static String SERVICE_NAME = "JournalComptableManager";

}
