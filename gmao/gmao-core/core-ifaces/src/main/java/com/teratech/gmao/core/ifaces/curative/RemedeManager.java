
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.Remede;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 16:50:24 GMT+01:00 2018
 * 
 */
public interface RemedeManager
    extends GenericManager<Remede, Long>
{

    public final static String SERVICE_NAME = "RemedeManager";

}
