
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierDepart;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Jul 18 13:37:32 GMT+01:00 2018
 * 
 */
public interface CourrierDepartManager
    extends GenericManager<CourrierDepart, Long>
{

    public final static String SERVICE_NAME = "CourrierDepartManager";
    public CourrierDepart confirmer(CourrierDepart entity);
    
    public CourrierDepart distribuer(CourrierDepart entity) ;
}
