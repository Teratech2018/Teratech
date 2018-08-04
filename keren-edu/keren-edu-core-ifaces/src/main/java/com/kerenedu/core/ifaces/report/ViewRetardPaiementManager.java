
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewRetardPaiement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 19 11:37:46 WAT 2018
 * 
 */
public interface ViewRetardPaiementManager
    extends GenericManager<ViewRetardPaiement, Long>
{

    public final static String SERVICE_NAME = "ViewRetardPaiementManager";
    
    public List<ViewRetardPaiement> getCriteres(ViewRetardPaiement critere) ;

}
