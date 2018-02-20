
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 10:30:55 CET 2018
 * 
 */
public interface ExamenManager
    extends GenericManager<Examen, Long>
{

    public final static String SERVICE_NAME = "ExamenManager";

}
