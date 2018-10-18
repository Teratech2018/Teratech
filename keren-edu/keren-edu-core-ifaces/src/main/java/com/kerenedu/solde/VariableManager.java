
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 12:16:54 WAT 2018
 * 
 */
public interface VariableManager
    extends GenericManager<Variable, Long>
{

    public final static String SERVICE_NAME = "VariableManager";

}
