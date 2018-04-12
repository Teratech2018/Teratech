
package com.keren.core.ifaces.recrutement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.recrutement.Recrutement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface RecrutementManager
    extends GenericManager<Recrutement, Long>
{

    public final static String SERVICE_NAME = "RecrutementManager";

}
