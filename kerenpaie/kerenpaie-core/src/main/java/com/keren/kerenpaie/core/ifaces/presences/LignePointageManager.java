
package com.keren.kerenpaie.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.presences.LignePointage;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 24 13:58:37 GMT+01:00 2018
 * 
 */
public interface LignePointageManager
    extends GenericManager<LignePointage, Long>
{

    public final static String SERVICE_NAME = "LignePointageManager";

}
