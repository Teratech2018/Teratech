
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 15:58:30 GMT+01:00 2018
 * 
 */
public interface SoumettreSalaireManager
    extends GenericManager<SoumettreSalaire, Long>
{

    public final static String SERVICE_NAME = "SoumettreSalaireManager";

}
