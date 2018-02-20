
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 18 21:27:11 WAT 2018
 * 
 */
public interface NiveauManager
    extends GenericManager<Niveau, Long>
{

    public final static String SERVICE_NAME = "NiveauManager";

}
