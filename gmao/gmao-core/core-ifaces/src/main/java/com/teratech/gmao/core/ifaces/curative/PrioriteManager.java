
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.Priorite;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Jul 15 11:56:39 GMT+01:00 2018
 * 
 */
public interface PrioriteManager
    extends GenericManager<Priorite, Long>
{

    public final static String SERVICE_NAME = "PrioriteManager";

}
