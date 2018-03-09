
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.Facture;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Feb 28 21:40:29 GMT+01:00 2018
 * 
 */
public interface BonReceptionManager
    extends GenericManager<BonReception, Long>
{

    public final static String SERVICE_NAME = "BonReceptionManager";
    
    /**
     * 
     * @param entity
     * @return 
     */
    public BonReception confirmer(BonReception entity);
    
    /**
     * 
     * @param entity
     * @return 
     */
    public BonReception rejeter(BonReception entity);
    
    /**
     * 
     * @param entity
     * @return 
     */
    public BonReception transferer(BonReception entity);
    
    /**
     * 
     * @param entity
     * @return 
     */
    public BonReception facturer(BonReception entity);
    
    /**
     * 
     * @param entity
     * @return 
     */
    public BonReception annuler(BonReception entity);

}
