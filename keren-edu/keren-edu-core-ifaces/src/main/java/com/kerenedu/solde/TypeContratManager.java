
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 12:40:08 WAT 2018
 * 
 */
public interface TypeContratManager
    extends GenericManager<TypeContrat, Long>
{

    public final static String SERVICE_NAME = "TypeContratManager";

}