
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Jul 08 15:59:49 WAT 2018
 * 
 */
public interface DepenseManager
    extends GenericManager<Depense, Long>
{

    public final static String SERVICE_NAME = "DepenseManager";

}
