
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewDltPaiement;
import com.kerenedu.model.report.ViewDltPaiementModal;
import com.kerenedu.model.report.ViewListingPModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 19 11:37:46 WAT 2018
 * 
 */
public interface ViewDltPaiementManager
    extends GenericManager<ViewDltPaiement, Long>
{

    public final static String SERVICE_NAME = "ViewDltPaiementManager";
    
	public List<ViewDltPaiement> getCriteres(ViewDltPaiementModal critere);
	
	public List<ViewDltPaiement> getCriteres(ViewListingPModal critere) ;

}
