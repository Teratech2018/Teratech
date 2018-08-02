
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 03 11:27:53 WAT 2018
 * 
 */
public interface MatiereDltManager
    extends GenericManager<MatiereDlt, Long>
{

    public final static String SERVICE_NAME = "MatiereDltManager";

}
