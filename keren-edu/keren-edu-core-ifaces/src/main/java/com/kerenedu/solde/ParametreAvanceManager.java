
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 12:40:08 WAT 2018
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
