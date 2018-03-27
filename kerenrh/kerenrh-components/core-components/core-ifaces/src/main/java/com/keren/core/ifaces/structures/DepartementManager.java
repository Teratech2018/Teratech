
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.Departement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 12:53:09 GMT+01:00 2018
 * 
 */
public interface DepartementManager
    extends GenericManager<Departement, Long>
{

    public final static String SERVICE_NAME = "DepartementManager";

}
