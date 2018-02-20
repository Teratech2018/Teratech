
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 11 10:03:44 WAT 2018
 * 
 */
public interface ClasseManager
    extends GenericManager<Classe, Long>
{

    public final static String SERVICE_NAME = "ClasseManager";

}
