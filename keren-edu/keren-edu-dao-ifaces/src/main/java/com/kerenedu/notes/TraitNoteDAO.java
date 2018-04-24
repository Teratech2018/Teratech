
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Apr 13 22:06:45 WAT 2018
 * 
 */
public interface TraitNoteDAO
    extends GenericDAO<TraitNote, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TraitNoteDAO";

}
