
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 10:23:10 CET 2018
 * 
 */
public interface MatiereNoteDAO
    extends GenericDAO<MatiereNote, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "MatiereNoteDAO";

}
