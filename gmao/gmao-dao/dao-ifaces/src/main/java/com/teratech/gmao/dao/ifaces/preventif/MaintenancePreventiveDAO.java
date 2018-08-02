
package com.teratech.gmao.dao.ifaces.preventif;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.preventif.MaintenancePreventive;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 16 21:57:14 GMT+01:00 2018
 * 
 */
public interface MaintenancePreventiveDAO
    extends GenericDAO<MaintenancePreventive, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "MaintenancePreventiveDAO";

}
