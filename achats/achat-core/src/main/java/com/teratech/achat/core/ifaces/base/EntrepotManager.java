
package com.teratech.achat.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.base.Entrepot;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 27 14:29:39 GMT+01:00 2018
 * 
 */
public interface EntrepotManager
    extends GenericManager<Entrepot, Long>
{

    public final static String SERVICE_NAME = "EntrepotManager";

}
