
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.EdtMasseSalModal;
import com.kerenedu.model.report.ViewMasseSalariale;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Jan 27 16:15:11 WAT 2019
 * 
 */
public interface ViewMasseSalarialeManager
    extends GenericManager<ViewMasseSalariale, Long>
{

    public final static String SERVICE_NAME = "ViewMasseSalarialeManager";
    
    public List<ViewMasseSalariale> getCriteres(EdtMasseSalModal critere);

}
