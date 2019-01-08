
package com.teratech.vente.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.comptabilite.Acompte;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 09:17:45 WAT 2019
 * 
 */
public interface AcompteManager
    extends GenericManager<Acompte, Long>
{

    public final static String SERVICE_NAME = "AcompteManager";

}
