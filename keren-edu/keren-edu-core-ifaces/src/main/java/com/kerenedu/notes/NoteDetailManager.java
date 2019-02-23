
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 10:30:55 CET 2018
 * 
 */
public interface NoteDetailManager
    extends GenericManager<NoteDetail, Long>
{

    public final static String SERVICE_NAME = "NoteDetailManager";
    
    public void importNote(List<NoteDetail> notelist ,MatiereNote matiere);
    
    public List<NoteDetail> findeleve(long idclasse);
    
    public long updateforce(ImportNoteClasse entity) ;

}
