
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.BonTravail;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 08:49:29 GMT+01:00 2018
 * 
 */
public interface BonTravailManager
    extends GenericManager<BonTravail, Long>
{

    public final static String SERVICE_NAME = "BonTravailManager";

}
