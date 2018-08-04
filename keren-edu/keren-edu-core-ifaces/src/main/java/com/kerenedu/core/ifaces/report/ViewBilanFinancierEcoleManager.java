
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewBilanFinancierEcole;
import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 19 15:43:31 WAT 2018
 * 
 */
public interface ViewBilanFinancierEcoleManager
    extends GenericManager<ViewBilanFinancierEcole, Long>
{

    public final static String SERVICE_NAME = "ViewBilanFinancierEcoleManager";
    
    public List<ViewBilanFinancierEcole> getCriteres(ViewBilanFinancierEcoleModal critere);

}
