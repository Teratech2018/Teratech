
package com.teratech.gmao.core.ifaces.preventif;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.preventif.TypePlanning;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 20:06:07 GMT+01:00 2018
 * 
 */
public interface TypePlanningManager
    extends GenericManager<TypePlanning, Long>
{

    public final static String SERVICE_NAME = "TypePlanningManager";

}
