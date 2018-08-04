
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 17 17:53:09 WAT 2018
 * 
 */
public interface TypeRemiseManager
    extends GenericManager<TypeRemise, Long>
{

    public final static String SERVICE_NAME = "TypeRemiseManager";

}
