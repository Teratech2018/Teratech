
package com.keren.core.ifaces.conges;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.conges.RepriseService;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 11:54:14 GMT+01:00 2018
 * 
 */
public interface RepriseServiceManager
    extends GenericManager<RepriseService, Long>
{

    public final static String SERVICE_NAME = "RepriseServiceManager";
    
    public RepriseService confirmer(RepriseService dmde);

}
