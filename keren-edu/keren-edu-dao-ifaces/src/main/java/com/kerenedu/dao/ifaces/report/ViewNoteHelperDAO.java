
package com.kerenedu.dao.ifaces.report;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.model.report.ViewNoteHelper;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 03 11:27:53 WAT 2018
 * 
 */
public interface ViewNoteHelperDAO
    extends GenericDAO<ViewNoteHelper, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewNoteHelperDAO";

}
