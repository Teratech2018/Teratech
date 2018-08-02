
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.CalendrierEquipement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 14:27:58 GMT+01:00 2018
 * 
 */
public interface CalendrierEquipementManager
    extends GenericManager<CalendrierEquipement, Long>
{

    public final static String SERVICE_NAME = "CalendrierEquipementManager";

}
