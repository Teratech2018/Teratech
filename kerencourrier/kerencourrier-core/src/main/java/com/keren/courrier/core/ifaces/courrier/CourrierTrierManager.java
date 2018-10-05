
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierTrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 28 17:51:17 WAT 2018
 * 
 */
public interface CourrierTrierManager
    extends GenericManager<CourrierTrier, Long>
{

    public final static String SERVICE_NAME = "CourrierTrierManager";

}
