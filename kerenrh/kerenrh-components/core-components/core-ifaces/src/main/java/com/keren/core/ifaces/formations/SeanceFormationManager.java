
package com.keren.core.ifaces.formations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.formations.SeanceFormation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface SeanceFormationManager
    extends GenericManager<SeanceFormation, Long>
{

    public final static String SERVICE_NAME = "SeanceFormationManager";
    
    public SeanceFormation valide(SeanceFormation entity);
    
    public SeanceFormation annule(SeanceFormation entity);

}
