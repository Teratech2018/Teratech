
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface CategoriePretManager
    extends GenericManager<CategoriePret, Long>
{

    public final static String SERVICE_NAME = "CategoriePretManager";

}
