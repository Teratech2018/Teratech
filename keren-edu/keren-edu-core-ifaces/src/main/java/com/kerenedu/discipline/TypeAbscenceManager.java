
package com.kerenedu.discipline;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
public interface TypeAbscenceManager
    extends GenericManager<TypeAbscence, Long>
{

    public final static String SERVICE_NAME = "TypeAbscenceManager";

}
