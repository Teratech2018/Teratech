
package com.teratech.achat.core.ifaces.tools;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.tools.ReponseToCommande;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 22 18:51:43 WAT 2018
 * 
 */
public interface ReponseToCommandeManager
    extends GenericManager<ReponseToCommande, Long>
{

    public final static String SERVICE_NAME = "ReponseToCommandeManager";

}
