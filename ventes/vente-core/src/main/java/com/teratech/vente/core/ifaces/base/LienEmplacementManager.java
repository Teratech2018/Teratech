
package com.teratech.vente.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 09:17:45 WAT 2019
 * 
 */
public interface LienEmplacementManager
    extends GenericManager<LienEmplacement, Long>
{

    public final static String SERVICE_NAME = "LienEmplacementManager";

}
