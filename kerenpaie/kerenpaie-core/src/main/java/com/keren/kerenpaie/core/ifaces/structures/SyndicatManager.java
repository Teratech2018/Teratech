
package com.keren.kerenpaie.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.structures.Syndicat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Apr 05 13:54:58 GMT+01:00 2018
 * 
 */
public interface SyndicatManager
    extends GenericManager<Syndicat, Long>
{

    public final static String SERVICE_NAME = "SyndicatManager";

}
