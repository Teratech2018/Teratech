
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.Variable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
public interface VariableManager
    extends GenericManager<Variable, Long>
{

    public final static String SERVICE_NAME = "VariableManager";

}
