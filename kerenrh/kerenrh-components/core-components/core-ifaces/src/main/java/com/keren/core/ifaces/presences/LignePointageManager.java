
package com.keren.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.presences.LignePointage;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Thu Feb 15 14:18:53 GMT+01:00 2018
 * 
 */
public interface LignePointageManager
    extends GenericManager<LignePointage, Long>
{

    public final static String SERVICE_NAME = "LignePointageManager";
    
    /**
     * Justification d'un retard
     * @param entity
     * @return
     */
    public LignePointage justifie(LignePointage entity);
    
    /**
     * 
     * @param entity
     * @return
     */
    public LignePointage nonjustifie(LignePointage entity);

}
