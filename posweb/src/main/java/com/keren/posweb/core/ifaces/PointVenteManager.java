
package com.keren.posweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.model.PointVente;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Sep 05 10:26:16 GMT+01:00 2018
 * 
 */
public interface PointVenteManager
    extends GenericManager<PointVente, Long>
{

    public final static String SERVICE_NAME = "PointVenteManager";

}
