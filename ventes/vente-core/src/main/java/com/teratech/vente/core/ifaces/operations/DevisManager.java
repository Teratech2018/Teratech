
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.Devis;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 10:14:00 WAT 2019
 * 
 */
public interface DevisManager
    extends GenericManager<Devis, Long>
{

    public final static String SERVICE_NAME = "DevisManager";

}
