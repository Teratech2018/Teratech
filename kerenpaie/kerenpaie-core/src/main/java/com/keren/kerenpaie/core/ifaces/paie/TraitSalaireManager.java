
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.TraitSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Mar 12 16:23:11 GMT+01:00 2018
 * 
 */
public interface TraitSalaireManager
    extends GenericManager<TraitSalaire, Long>
{

    public final static String SERVICE_NAME = "TraitSalaireManager";

}
