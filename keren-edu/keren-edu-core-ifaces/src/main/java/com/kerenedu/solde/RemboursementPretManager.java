
package com.kerenedu.solde;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewRetenueModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface RemboursementPretManager
    extends GenericManager<RemboursementPret, Long>
{

    public final static String SERVICE_NAME = "RemboursementPretManager";
    public RemboursementPret confirme(RemboursementPret entity,PeriodePaie periode);

	
 	public RemboursementPret annule(RemboursementPret entity);

	public List<RemboursementPret> getCriteres(ViewRetenueModal critere) ;
}
