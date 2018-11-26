
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewMatiereClasseModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 10:23:10 CET 2018
 * 
 */
public interface MatiereNoteManager
    extends GenericManager<MatiereNote, Long>
{

    public final static String SERVICE_NAME = "MatiereNoteManager";
    public List<MatiereNote> getCriteres(ViewMatiereClasseModal critere);
    
    public void importNote(MatiereNote entity);

}
