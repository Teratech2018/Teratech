
package com.teratech.stock.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Dec 29 19:27:06 WAT 2018
 * 
 */
public interface LienEmplacementManager
    extends GenericManager<LienEmplacement, Long>
{

    public final static String SERVICE_NAME = "LienEmplacementManager";

}
