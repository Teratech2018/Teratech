
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.ValiderSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 16:31:04 GMT+01:00 2018
 * 
 */
public interface ValiderSalaireManager
    extends GenericManager<ValiderSalaire, Long>
{

    public final static String SERVICE_NAME = "ValiderSalaireManager";

}
