
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierADeclasser;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Aug 01 17:08:49 GMT+01:00 2018
 * 
 */
public interface CourrierADeclasserManager
    extends GenericManager<CourrierADeclasser, Long>
{

    public final static String SERVICE_NAME = "CourrierADeclasserManager";

}
