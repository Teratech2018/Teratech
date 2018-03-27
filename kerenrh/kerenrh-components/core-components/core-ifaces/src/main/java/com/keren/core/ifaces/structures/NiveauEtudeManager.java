
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.NiveauEtude;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 14:12:28 GMT+01:00 2018
 * 
 */
public interface NiveauEtudeManager
    extends GenericManager<NiveauEtude, Long>
{

    public final static String SERVICE_NAME = "NiveauEtudeManager";

}
