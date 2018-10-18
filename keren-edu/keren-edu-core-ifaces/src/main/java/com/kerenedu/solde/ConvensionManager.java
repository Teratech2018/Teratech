
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;

/**
 * Interface etendue par les interfaces locale et remote du manager
 * 
 * @since Thu Oct 11 12:02:33 WAT 2018
 * 
 */
public interface ConvensionManager extends GenericManager<Convension, Long> {

	public final static String SERVICE_NAME = "ConvensionManager";

	public Convension actif(Convension entity);

	public Convension inactif(Convension entity);

	public Convension genere(Convension entity);
}
