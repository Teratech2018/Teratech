
package com.teratech.vente.core.ifaces.banques;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.banques.Banque;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:36 WAT 2019
 * 
 */
public interface BanqueManager
    extends GenericManager<Banque, Long>
{

    public final static String SERVICE_NAME = "BanqueManager";

}
