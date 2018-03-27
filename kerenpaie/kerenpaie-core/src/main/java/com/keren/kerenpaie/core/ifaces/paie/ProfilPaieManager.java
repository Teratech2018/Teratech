
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.ProfilPaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 06 14:40:10 GMT+01:00 2018
 * 
 */
public interface ProfilPaieManager
    extends GenericManager<ProfilPaie, Long>
{

    public final static String SERVICE_NAME = "ProfilPaieManager";

}
