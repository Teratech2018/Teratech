
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 31 10:33:47 WAT 2019
 * 
 */
public interface ParaCoutMatiereManager
    extends GenericManager<ParaCoutMatiere, Long>
{

    public final static String SERVICE_NAME = "ParaCoutMatiereManager";

}
