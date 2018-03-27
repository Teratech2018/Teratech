
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.PrepaSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 16:41:23 GMT+01:00 2018
 * 
 */
public interface PrepaSalaireManager
    extends GenericManager<PrepaSalaire, Long>
{

    public final static String SERVICE_NAME = "PrepaSalaireManager";

}
