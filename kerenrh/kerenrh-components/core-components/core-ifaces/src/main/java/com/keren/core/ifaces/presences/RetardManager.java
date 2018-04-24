
package com.keren.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.presences.Retard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Apr 23 09:28:00 GMT+01:00 2018
 * 
 */
public interface RetardManager
    extends GenericManager<Retard, Long>
{

    public final static String SERVICE_NAME = "RetardManager";
    
    /**
     * Justification d'un retard
     * @param entity
     * @return
     */
    public Retard justifie(Retard entity);
    
    /**
     * 
     * @param entity
     * @return
     */
    public Retard nonjustifie(Retard entity);

}
