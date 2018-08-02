
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jun 18 16:55:33 WAT 2018
 * 
 */
public interface TypeDepenseManager
    extends GenericManager<TypeDepense, Long>
{

    public final static String SERVICE_NAME = "TypeDepenseManager";

}
