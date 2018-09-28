
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Sep 04 13:51:28 WAT 2018
 * 
 */
public interface MoratoireManager
    extends GenericManager<Moratoire, Long>
{

    public final static String SERVICE_NAME = "MoratoireManager";

}
