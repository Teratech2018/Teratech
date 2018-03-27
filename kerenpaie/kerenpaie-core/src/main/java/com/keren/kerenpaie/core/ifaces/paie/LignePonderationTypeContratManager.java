
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
public interface LignePonderationTypeContratManager
    extends GenericManager<LignePonderationTypeContrat, Long>
{

    public final static String SERVICE_NAME = "LignePonderationTypeContratManager";

}
