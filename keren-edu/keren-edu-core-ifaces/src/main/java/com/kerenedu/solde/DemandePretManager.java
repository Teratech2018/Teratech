
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface DemandePretManager
    extends GenericManager<DemandePret, Long>
{

    public final static String SERVICE_NAME = "DemandePretManager";
    public DemandePret generereglements(DemandePret entity);
	
  	public DemandePret confirme(DemandePret entity);

  	
  	public DemandePret annule(DemandePret entity);
}
