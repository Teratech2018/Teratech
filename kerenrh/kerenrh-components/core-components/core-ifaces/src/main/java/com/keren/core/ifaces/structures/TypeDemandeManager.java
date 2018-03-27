
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.TypeDemande;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 13:58:01 GMT+01:00 2018
 * 
 */
public interface TypeDemandeManager
    extends GenericManager<TypeDemande, Long>
{

    public final static String SERVICE_NAME = "TypeDemandeManager";

}
