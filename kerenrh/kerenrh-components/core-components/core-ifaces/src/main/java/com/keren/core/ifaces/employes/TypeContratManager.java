
package com.keren.core.ifaces.employes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.employes.TypeContrat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 13:56:56 GMT+01:00 2018
 * 
 */
public interface TypeContratManager
    extends GenericManager<TypeContrat, Long>
{

    public final static String SERVICE_NAME = "TypeContratManager";

}
