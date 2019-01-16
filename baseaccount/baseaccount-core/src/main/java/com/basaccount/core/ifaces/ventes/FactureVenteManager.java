
package com.basaccount.core.ifaces.ventes;

import com.basaccount.model.ventes.FactureVente;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 15 20:58:54 WAT 2019
 * 
 */
public interface FactureVenteManager
    extends GenericManager<FactureVente, Long>
{

    public final static String SERVICE_NAME = "FactureVenteManager";

}
