
package com.kerenedu.school;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jun 11 02:42:49 WAT 2018
 * 
 */
public interface ResponsableManager
    extends GenericManager<Responsable, Long>
{

    public final static String SERVICE_NAME = "ResponsableManager";

}
