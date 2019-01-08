
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Dec 21 10:42:40 WAT 2018
 * 
 */
public interface BuilderLigneNoteManager
    extends GenericManager<BuilderLigneNote, Long>
{

    public final static String SERVICE_NAME = "BuilderLigneNoteManager";

}
