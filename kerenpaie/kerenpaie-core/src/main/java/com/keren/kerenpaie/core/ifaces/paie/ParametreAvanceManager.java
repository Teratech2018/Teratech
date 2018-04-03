
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.ParametreAvance;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 23 14:48:53 GMT+01:00 2018
 * 
 */
public interface ParametreAvanceManager
    extends GenericManager<ParametreAvance, Long>
{

    public final static String SERVICE_NAME = "ParametreAvanceManager";
    
    public ParametreAvance actif(ParametreAvance entity);
	
	public ParametreAvance inactif(ParametreAvance entity);
	
	public ParametreAvance genere(ParametreAvance entity);

}
