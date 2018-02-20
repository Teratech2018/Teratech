
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Feb 12 14:36:24 CET 2018
 * 
 */
public interface UniteEnsManager
    extends GenericManager<UniteEns, Long>
{

    public final static String SERVICE_NAME = "UniteEnsManager";

}
