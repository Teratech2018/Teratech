
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.Specialite;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 14:12:28 GMT+01:00 2018
 * 
 */
public interface SpecialiteManager
    extends GenericManager<Specialite, Long>
{

    public final static String SERVICE_NAME = "SpecialiteManager";

}
