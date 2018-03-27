
package com.keren.kerenpaie.core.ifaces.prets;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.prets.RemboursementPret;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface RemboursementPretManager
    extends GenericManager<RemboursementPret, Long>
{

    public final static String SERVICE_NAME = "RemboursementPretManager";
    
    public RemboursementPret confirme(RemboursementPret entity,PeriodePaie periode);

	
	public RemboursementPret annule(RemboursementPret entity);

}
