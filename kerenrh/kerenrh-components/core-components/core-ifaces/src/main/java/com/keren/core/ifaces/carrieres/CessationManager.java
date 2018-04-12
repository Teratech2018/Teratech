
package com.keren.core.ifaces.carrieres;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.carrieres.Cessation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface CessationManager
    extends GenericManager<Cessation, Long>
{

    public final static String SERVICE_NAME = "CessationManager";

}
