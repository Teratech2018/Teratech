
package com.basaccount.core.ifaces.ventes;

import com.basaccount.model.ventes.NoteFraisVente;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 15 23:13:05 WAT 2019
 * 
 */
public interface NoteFraisVenteManager
    extends GenericManager<NoteFraisVente, Long>
{

    public final static String SERVICE_NAME = "NoteFraisVenteManager";

}
