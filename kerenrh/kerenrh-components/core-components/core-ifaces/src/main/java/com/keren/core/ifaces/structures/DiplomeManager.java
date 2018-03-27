
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.Diplome;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 14:12:56 GMT+01:00 2018
 * 
 */
public interface DiplomeManager
    extends GenericManager<Diplome, Long>
{

    public final static String SERVICE_NAME = "DiplomeManager";

}
