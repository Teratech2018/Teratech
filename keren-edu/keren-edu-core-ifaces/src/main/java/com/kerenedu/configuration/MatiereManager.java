
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
public interface MatiereManager
    extends GenericManager<Matiere, Long>
{

    public final static String SERVICE_NAME = "MatiereManager";

}
