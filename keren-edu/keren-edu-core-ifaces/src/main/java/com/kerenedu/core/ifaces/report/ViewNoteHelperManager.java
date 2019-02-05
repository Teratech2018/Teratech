
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.kerenedu.model.report.ViewNoteClasseModal;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.NoteDetail;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 03 11:27:53 WAT 2018
 * 
 */
public interface ViewNoteHelperManager
    extends GenericManager<ViewNoteHelper, Long>
{

    public final static String SERVICE_NAME = "ViewNoteHelperManager";
    
    public List<ViewNoteHelper> getCriteres(ViewMatiereClasseModal critere);
    
    public List<ViewNoteHelper> getCriteres(ViewNoteClasseModal critere);
    
	public List<NoteDetail> getCriterenote(ViewNoteClasseModal critere) ;

}
