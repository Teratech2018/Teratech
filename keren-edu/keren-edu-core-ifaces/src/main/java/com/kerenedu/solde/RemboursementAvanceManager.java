
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface RemboursementAvanceManager
    extends GenericManager<RemboursementAvance, Long>
{

    public final static String SERVICE_NAME = "RemboursementAvanceManager";
    
    public RemboursementAvance valider(RemboursementAvance entity,PeriodePaie periode);
	
	public RemboursementAvance refuser(RemboursementAvance entity);

}
