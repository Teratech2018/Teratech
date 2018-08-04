
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewBilanFinancier;
import com.kerenedu.model.report.ViewBilanFinancierModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 19 10:58:41 WAT 2018
 * 
 */
public interface ViewBilanFinancierManager
    extends GenericManager<ViewBilanFinancier, Long>
{

    public final static String SERVICE_NAME = "ViewBilanFinancierManager";
    public List<ViewBilanFinancier> getCriteres(ViewBilanFinancierModal critere);

}
