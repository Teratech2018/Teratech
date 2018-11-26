
package com.kerenedu.core.ifaces.report;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewNotematiere;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface ViewNotematiereManager
    extends GenericManager<ViewNotematiere, Long>
{

    public final static String SERVICE_NAME = "ViewNotematiereManager";

}
