
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 10:30:55 CET 2018
 * 
 */
public interface NoteDetailDAO
    extends GenericDAO<NoteDetail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NoteDetailDAO";
	public long updateforce(ImportNoteClasse entity) ;
	
	public long updateforce2(EdtBulletin prepa) ;

}
