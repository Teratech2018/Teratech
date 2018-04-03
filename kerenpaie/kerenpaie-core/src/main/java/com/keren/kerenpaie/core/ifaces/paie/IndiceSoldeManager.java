
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.IndiceSolde;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 30 15:55:02 GMT+01:00 2018
 * 
 */
public interface IndiceSoldeManager
    extends GenericManager<IndiceSolde, Long>
{

    public final static String SERVICE_NAME = "IndiceSoldeManager";
    
   public IndiceSolde actif(IndiceSolde entity);
	
	public IndiceSolde inactif(IndiceSolde entity);	

}
