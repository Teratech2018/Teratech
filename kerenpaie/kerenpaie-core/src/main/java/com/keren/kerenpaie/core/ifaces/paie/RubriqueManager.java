
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.Rubrique;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
public interface RubriqueManager
    extends GenericManager<Rubrique, Long>
{

    public final static String SERVICE_NAME = "RubriqueManager";
    
    public Rubrique genereforfait(Rubrique entity) ;

}
