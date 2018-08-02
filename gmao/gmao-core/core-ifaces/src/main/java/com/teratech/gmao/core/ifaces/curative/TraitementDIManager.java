
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.TraitementDI;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 17 13:56:41 GMT+01:00 2018
 * 
 */
public interface TraitementDIManager
    extends GenericManager<TraitementDI, Long>
{

    public final static String SERVICE_NAME = "TraitementDIManager";

}
