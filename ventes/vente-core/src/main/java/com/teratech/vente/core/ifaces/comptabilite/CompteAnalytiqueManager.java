
package com.teratech.vente.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.comptabilite.CompteAnalytique;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:36 WAT 2019
 * 
 */
public interface CompteAnalytiqueManager
    extends GenericManager<CompteAnalytique, Long>
{

    public final static String SERVICE_NAME = "CompteAnalytiqueManager";

}
