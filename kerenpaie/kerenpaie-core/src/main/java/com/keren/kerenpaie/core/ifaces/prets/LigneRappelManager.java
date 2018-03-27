
package com.keren.kerenpaie.core.ifaces.prets;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.prets.LigneRappel;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface LigneRappelManager
    extends GenericManager<LigneRappel, Long>
{

    public final static String SERVICE_NAME = "LigneRappelManager";

}
