
package com.keren.dao.ifaces.conges;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.conges.RepriseService;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 11:54:13 GMT+01:00 2018
 * 
 */
public interface RepriseServiceDAO
    extends GenericDAO<RepriseService, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RepriseServiceDAO";

}
