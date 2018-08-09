
package com.keren.courrier.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.referentiel.RappelCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 31 12:08:43 WAT 2018
 * 
 */
public interface RappelCourrierManager
    extends GenericManager<RappelCourrier, Long>
{

    public final static String SERVICE_NAME = "RappelCourrierManager";

}
