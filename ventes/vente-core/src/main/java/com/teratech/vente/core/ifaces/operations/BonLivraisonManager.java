
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.BonLivraison;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Fri Jan 04 21:36:00 WAT 2019
 * 
 */
public interface BonLivraisonManager
    extends GenericManager<BonLivraison, Long>
{

    public final static String SERVICE_NAME = "BonLivraisonManager";

    
    public BonLivraison confirmer(BonLivraison entity);
}
