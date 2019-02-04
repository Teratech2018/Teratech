
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.model.report.ViewPeriodeModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Nov 30 09:20:28 WAT 2018
 * 
 */
public interface ViewBulletinPaieHelperManager
    extends GenericManager<ViewBulletinPaieHelper, Long>
{

    public final static String SERVICE_NAME = "ViewBulletinPaieHelperManager";
    
    public List<ViewBulletinPaieHelper> getCriteres(EdtPeriodeModal critere);
    
    public List<ViewBulletinPaieHelper> getCriteres(ViewPeriodeModal critere);

}
