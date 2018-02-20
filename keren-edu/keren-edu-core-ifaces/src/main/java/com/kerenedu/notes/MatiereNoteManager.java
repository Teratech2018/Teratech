
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 10:23:10 CET 2018
 * 
 */
public interface MatiereNoteManager
    extends GenericManager<MatiereNote, Long>
{

    public final static String SERVICE_NAME = "MatiereNoteManager";

}
