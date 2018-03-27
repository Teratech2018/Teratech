
package com.keren.kerenpaie.core.ifaces.employes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.employes.Fonction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
public interface FonctionManager
    extends GenericManager<Fonction, Long>
{

    public final static String SERVICE_NAME = "FonctionManager";

}
