
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.Courrier;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Jul 18 10:58:43 GMT+01:00 2018
 * 
 */
public interface CourrierManager
    extends GenericManager<Courrier, Long>
{

    public final static String SERVICE_NAME = "CourrierManager";
//    public Courrier confirmer(Courrier entity);

}
