
package com.teratech.gmao.core.ifaces.preventif;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.preventif.Gamme;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 09:45:19 GMT+01:00 2018
 * 
 */
public interface GammeManager
    extends GenericManager<Gamme, Long>
{

    public final static String SERVICE_NAME = "GammeManager";

}
