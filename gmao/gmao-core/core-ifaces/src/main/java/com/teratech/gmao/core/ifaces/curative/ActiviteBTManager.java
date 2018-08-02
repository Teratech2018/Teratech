
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.ActiviteBT;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 15:57:37 GMT+01:00 2018
 * 
 */
public interface ActiviteBTManager
    extends GenericManager<ActiviteBT, Long>
{

    public final static String SERVICE_NAME = "ActiviteBTManager";

}
