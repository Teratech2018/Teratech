
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Contrat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 10:49:38 GMT+01:00 2018
 * 
 */
public interface ContratManager
    extends GenericManager<Contrat, Long>
{

    public final static String SERVICE_NAME = "ContratManager";

}
