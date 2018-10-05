
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierAArchiver;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Aug 23 14:35:51 WAT 2018
 * 
 */
public interface CourrierAArchiverManager
    extends GenericManager<CourrierAArchiver, Long>
{

    public final static String SERVICE_NAME = "CourrierAArchiverManager";

}
