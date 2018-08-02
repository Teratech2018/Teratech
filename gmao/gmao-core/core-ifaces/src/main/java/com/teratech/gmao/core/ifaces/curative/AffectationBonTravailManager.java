
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.AffectationBonTravail;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 17 13:30:30 GMT+01:00 2018
 * 
 */
public interface AffectationBonTravailManager
    extends GenericManager<AffectationBonTravail, Long>
{

    public final static String SERVICE_NAME = "AffectationBonTravailManager";

}
