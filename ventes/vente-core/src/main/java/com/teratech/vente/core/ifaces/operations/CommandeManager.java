
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.Commande;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 12:32:06 WAT 2019
 * 
 */
public interface CommandeManager
    extends GenericManager<Commande, Long>
{

    public final static String SERVICE_NAME = "CommandeManager";

}
