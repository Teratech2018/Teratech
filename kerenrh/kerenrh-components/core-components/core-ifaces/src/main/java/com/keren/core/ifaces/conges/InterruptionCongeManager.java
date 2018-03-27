
package com.keren.core.ifaces.conges;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.conges.InterruptionConge;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 11:54:14 GMT+01:00 2018
 * 
 */
public interface InterruptionCongeManager
    extends GenericManager<InterruptionConge, Long>
{

    public final static String SERVICE_NAME = "InterruptionCongeManager";
    
    public InterruptionConge confirmer(InterruptionConge dmde);

}
