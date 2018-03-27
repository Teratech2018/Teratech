
package com.keren.core.ifaces.employes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.employes.DepartementSoc;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 13:16:29 GMT+01:00 2018
 * 
 */
public interface DepartementSocManager
    extends GenericManager<DepartementSoc, Long>
{

    public final static String SERVICE_NAME = "DepartementSocManager";

}
