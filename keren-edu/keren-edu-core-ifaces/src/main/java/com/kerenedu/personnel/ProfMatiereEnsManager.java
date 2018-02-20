
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Jan 31 12:09:08 CET 2018
 * 
 */
public interface ProfMatiereEnsManager
    extends GenericManager<ProfMatiereEns, Long>
{

    public final static String SERVICE_NAME = "ProfMatiereEnsManager";

}
