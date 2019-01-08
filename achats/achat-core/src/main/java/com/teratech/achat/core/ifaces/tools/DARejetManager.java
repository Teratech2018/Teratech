
package com.teratech.achat.core.ifaces.tools;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.tools.DARejet;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Dec 21 15:08:09 WAT 2018
 * 
 */
public interface DARejetManager
    extends GenericManager<DARejet, Long>
{

    public final static String SERVICE_NAME = "DARejetManager";

}
