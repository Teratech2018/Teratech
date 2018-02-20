
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 25 00:49:48 CET 2018
 * 
 */
public interface CaisseManager
    extends GenericManager<Caisse, Long>
{

    public final static String SERVICE_NAME = "CaisseManager";

}
