
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Apr 13 22:06:45 WAT 2018
 * 
 */
public interface TraitNoteManager
    extends GenericManager<TraitNote, Long>
{

    public final static String SERVICE_NAME = "TraitNoteManager";

}
