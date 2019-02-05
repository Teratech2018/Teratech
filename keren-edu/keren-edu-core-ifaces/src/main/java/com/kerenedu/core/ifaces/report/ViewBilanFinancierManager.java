
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewBilanFinancier;
import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;
import com.kerenedu.model.report.ViewBilanFinancierModal;
import com.kerenedu.model.report.ViewBilanServiceModal;
import com.kerenedu.model.report.ViewCouponsInformation;


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
    
    public List<ViewBilanFinancier> getCriteres(ViewBilanServiceModal critere);
    
	public List<Inscription> getEleveElligible(ViewBilanServiceModal critere);
	
	public List<ViewBilanFinancier> getCriteres(ViewBilanFinancierEcoleModal critere) ;


}
