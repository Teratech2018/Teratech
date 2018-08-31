
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Aug 18 07:35:01 WAT 2018
 * 
 */
public interface RecetteManager
    extends GenericManager<Recette, Long>
{

    public final static String SERVICE_NAME = "RecetteManager";

}
