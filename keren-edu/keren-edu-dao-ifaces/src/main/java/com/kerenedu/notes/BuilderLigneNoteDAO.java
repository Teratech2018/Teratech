
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Dec 21 10:42:40 WAT 2018
 * 
 */
public interface BuilderLigneNoteDAO
    extends GenericDAO<BuilderLigneNote, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BuilderLigneNoteDAO";

}
