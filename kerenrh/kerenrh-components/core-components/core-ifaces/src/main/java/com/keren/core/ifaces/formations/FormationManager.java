
package com.keren.core.ifaces.formations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.formations.Formation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 11 16:28:46 GMT+01:00 2018
 * 
 */
public interface FormationManager
    extends GenericManager<Formation, Long>
{

    public final static String SERVICE_NAME = "FormationManager";
    
    /**
     * Validation de la formation
     * @param entity
     * @return
     */
    public Formation valide(Formation entity);
    
    public Formation annule(Formation entity);
    
    public Formation cloture(Formation entity);

}
