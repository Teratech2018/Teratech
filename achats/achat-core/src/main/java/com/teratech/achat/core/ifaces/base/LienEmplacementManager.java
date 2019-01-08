
package com.teratech.achat.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 27 15:19:46 WAT 2018
 * 
 */
public interface LienEmplacementManager
    extends GenericManager<LienEmplacement, Long>
{

    public final static String SERVICE_NAME = "LienEmplacementManager";

}
