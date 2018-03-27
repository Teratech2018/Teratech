
package com.keren.kerenpaie.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.SectionAnalytique;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
public interface SectionAnalytiqueManager
    extends GenericManager<SectionAnalytique, Long>
{

    public final static String SERVICE_NAME = "SectionAnalytiqueManager";

}
