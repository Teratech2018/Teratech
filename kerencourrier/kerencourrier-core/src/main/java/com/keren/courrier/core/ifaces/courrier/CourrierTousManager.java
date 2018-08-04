
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierTous;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 31 15:26:59 GMT+01:00 2018
 * 
 */
public interface CourrierTousManager
    extends GenericManager<CourrierTous, Long>
{

    public final static String SERVICE_NAME = "CourrierTousManager";

}
