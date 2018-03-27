
package com.keren.kerenpaie.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.structures.Diplome;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
public interface DiplomeManager
    extends GenericManager<Diplome, Long>
{

    public final static String SERVICE_NAME = "DiplomeManager";

}
