
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 10:30:55 CET 2018
 * 
 */
public interface NoteManager
    extends GenericManager<Note, Long>
{

    public final static String SERVICE_NAME = "NoteManager";

}
