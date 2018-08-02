
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Rubrique;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 15:15:32 GMT+01:00 2018
 * 
 */
public interface RubriqueManager
    extends GenericManager<Rubrique, Long>
{

    public final static String SERVICE_NAME = "RubriqueManager";

}
