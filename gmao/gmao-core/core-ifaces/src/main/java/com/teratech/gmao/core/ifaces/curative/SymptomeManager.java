
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.Symptome;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Jul 15 11:56:39 GMT+01:00 2018
 * 
 */
public interface SymptomeManager
    extends GenericManager<Symptome, Long>
{

    public final static String SERVICE_NAME = "SymptomeManager";

}
