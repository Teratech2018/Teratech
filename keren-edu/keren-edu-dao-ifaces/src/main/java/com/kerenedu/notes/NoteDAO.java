
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 10:30:54 CET 2018
 * 
 */
public interface NoteDAO
    extends GenericDAO<Note, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NoteDAO";

}
