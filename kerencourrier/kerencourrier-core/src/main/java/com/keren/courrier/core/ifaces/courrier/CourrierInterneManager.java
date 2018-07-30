
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierInterne;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Jul 18 13:37:32 GMT+01:00 2018
 * 
 */
public interface CourrierInterneManager
    extends GenericManager<CourrierInterne, Long>
{

    public final static String SERVICE_NAME = "CourrierInterneManager";
    public CourrierInterne confirmer(CourrierInterne entity);
}
