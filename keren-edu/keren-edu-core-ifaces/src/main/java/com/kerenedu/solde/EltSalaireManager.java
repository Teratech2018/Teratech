
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Sep 14 16:06:52 WAT 2018
 * 
 */
public interface EltSalaireManager
    extends GenericManager<EltSalaire, Long>
{

    public final static String SERVICE_NAME = "EltSalaireManager";

}
