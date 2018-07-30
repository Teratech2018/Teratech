
package com.keren.courrier.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.referentiel.NatureCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Jul 18 14:02:05 GMT+01:00 2018
 * 
 */
public interface NatureCourrierManager
    extends GenericManager<NatureCourrier, Long>
{

    public final static String SERVICE_NAME = "NatureCourrierManager";

}
