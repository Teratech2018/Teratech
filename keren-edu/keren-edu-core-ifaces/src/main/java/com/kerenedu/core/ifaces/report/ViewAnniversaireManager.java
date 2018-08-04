
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewAnniversaire;
import com.kerenedu.model.report.ViewAnniversaireModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewAnniversaireManager
    extends GenericManager<ViewAnniversaire, Long>
{

    public final static String SERVICE_NAME = "ViewAnniversaireManager";
    
    public List<ViewAnniversaire> getCriteres(ViewAnniversaireModal critere);
    
    public List<ViewAnniversaire> getCriteres(ViewAnniversaire critere);

}
