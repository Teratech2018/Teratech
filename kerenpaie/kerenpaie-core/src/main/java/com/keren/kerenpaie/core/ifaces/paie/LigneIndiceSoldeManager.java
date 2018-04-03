
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 30 15:55:03 GMT+01:00 2018
 * 
 */
public interface LigneIndiceSoldeManager
    extends GenericManager<LigneIndiceSolde, Long>
{

    public final static String SERVICE_NAME = "LigneIndiceSoldeManager";

}
