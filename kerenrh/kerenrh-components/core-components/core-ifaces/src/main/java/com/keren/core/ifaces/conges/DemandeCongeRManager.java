
package com.keren.core.ifaces.conges;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.conges.DemandeCongeR;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
public interface DemandeCongeRManager
    extends GenericManager<DemandeCongeR, Long>
{

    public final static String SERVICE_NAME = "DemandeCongeRManager";

}
