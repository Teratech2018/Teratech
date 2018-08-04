
package com.kerenedu.core.ifaces.report;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewNoteHelper;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 03 11:27:53 WAT 2018
 * 
 */
public interface ViewNoteHelperManager
    extends GenericManager<ViewNoteHelper, Long>
{

    public final static String SERVICE_NAME = "ViewNoteHelperManager";

}
