
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Jan 16 12:36:33 WAT 2019
 * 
 */
public interface StatistiqueNotesManager
    extends GenericManager<StatistiqueNotes, Long>
{

    public final static String SERVICE_NAME = "StatistiqueNotesManager";

}
