
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.ActiviteHBT;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 17:19:57 GMT+01:00 2018
 * 
 */
public interface ActiviteHBTManager
    extends GenericManager<ActiviteHBT, Long>
{

    public final static String SERVICE_NAME = "ActiviteHBTManager";

}
