
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewBilanServiceEleve;
import com.kerenedu.model.report.ViewBilanServiceModal;
import com.kerenedu.model.report.ViewCouponsInformation;
import com.kerenedu.model.report.ViewRetardPaiement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 14 15:47:40 WAT 2018
 * 
 */
public interface ViewBilanServiceEleveManager
    extends GenericManager<ViewBilanServiceEleve, Long>
{

    public final static String SERVICE_NAME = "ViewBilanServiceEleveManager";
    
    public List<ViewBilanServiceEleve> getCriteres(ViewBilanServiceModal entity);
    
    public List<ViewBilanServiceEleve> getCriteresRetard(ViewRetardPaiement critere) ;
    
    public List<ViewBilanServiceEleve> getCriteres(ViewCouponsInformation critere) ;
    
    public List<Inscription> getCriteresinscrit(ViewCouponsInformation critere) ;

}
