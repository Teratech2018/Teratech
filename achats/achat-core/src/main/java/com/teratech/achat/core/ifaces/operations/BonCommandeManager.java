
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue Feb 27 14:29:39 GMT+01:00 2018
 * 
 */
public interface BonCommandeManager
    extends GenericManager<BonCommande, Long>
{

    public final static String SERVICE_NAME = "BonCommandeManager";
    
    public BonCommande envoyer(BonCommande entity);
    
    
    public BonCommande confirmer(BonCommande entity);
    
     public BonReception reception(BonCommande entity);
    
    
    public BonCommande annuler(BonCommande entity);
    
    
   public BonCommande facture(BonCommande entity);

}
