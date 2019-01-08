
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.LigneCommande;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 13:43:20 WAT 2019
 * 
 */
public interface LigneCommandeManager
    extends GenericManager<LigneCommande, Long>
{

    public final static String SERVICE_NAME = "LigneCommandeManager";

}
