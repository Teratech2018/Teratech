
package com.keren.core.ifaces.formations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.formations.BesionFormation;
import com.keren.model.formations.GenererBesionFormation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface BesionFormationManager
    extends GenericManager<BesionFormation, Long>
{

    public final static String SERVICE_NAME = "BesionFormationManager";
    
    /**
     * Validation
     * @param entity
     * @return
     */
    public BesionFormation valide(BesionFormation entity);
    
    /**
     * Generation du Besion de formation a partir 
     * @param entity
     * @return
     */
    public BesionFormation genererBF(GenererBesionFormation entity);

}
