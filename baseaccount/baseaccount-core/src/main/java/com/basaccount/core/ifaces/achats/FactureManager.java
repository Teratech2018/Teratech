
package com.basaccount.core.ifaces.achats;

import com.basaccount.model.achats.Facture;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Mar 14 21:10:26 GMT+01:00 2018
 * 
 */
public interface FactureManager
    extends GenericManager<Facture, Long>
{

    public final static String SERVICE_NAME = "FactureManager";

}
