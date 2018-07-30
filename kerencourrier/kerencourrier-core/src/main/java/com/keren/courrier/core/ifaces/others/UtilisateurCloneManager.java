
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.UtilisateurClone;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 26 12:15:36 GMT+01:00 2018
 * 
 */
public interface UtilisateurCloneManager
    extends GenericManager<UtilisateurClone, Long>
{

    public final static String SERVICE_NAME = "UtilisateurCloneManager";

}
