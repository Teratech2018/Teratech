
package com.teratech.gmao.dao.ifaces.curative;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.curative.ActiviteBT;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 16 15:57:36 GMT+01:00 2018
 * 
 */
public interface ActiviteBTDAO
    extends GenericDAO<ActiviteBT, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ActiviteBTDAO";

}
