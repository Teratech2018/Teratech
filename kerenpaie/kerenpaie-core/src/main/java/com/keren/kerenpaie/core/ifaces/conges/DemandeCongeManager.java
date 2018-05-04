
package com.keren.kerenpaie.core.ifaces.conges;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.conges.DemandeConge;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 24 13:58:37 GMT+01:00 2018
 * 
 */
public interface DemandeCongeManager
    extends GenericManager<DemandeConge, Long>
{

    public final static String SERVICE_NAME = "DemandeCongeManager";

}
