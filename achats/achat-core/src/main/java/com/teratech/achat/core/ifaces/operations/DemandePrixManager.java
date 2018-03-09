
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.DemandePrix;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue Feb 27 14:29:39 GMT+01:00 2018
 * 
 */
public interface DemandePrixManager
    extends GenericManager<DemandePrix, Long>
{

    public final static String SERVICE_NAME = "DemandePrixManager";
    
    
    public DemandePrix confirmer(DemandePrix entity);
    
    public DemandePrix envoyer(DemandePrix entity);
    
    public DemandePrix engage(DemandePrix entity);
    
    public DemandePrix annule(DemandePrix entity);

}
