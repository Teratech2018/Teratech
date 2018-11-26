
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface EnseignantSecondaireManager
    extends GenericManager<EnseignantSecondaire, Long>
{

    public final static String SERVICE_NAME = "EnseignantSecondaireManager";

}
