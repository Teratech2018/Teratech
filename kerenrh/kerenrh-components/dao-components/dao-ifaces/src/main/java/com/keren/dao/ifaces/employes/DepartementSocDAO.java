
package com.keren.dao.ifaces.employes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.employes.DepartementSoc;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 13:16:29 GMT+01:00 2018
 * 
 */
public interface DepartementSocDAO
    extends GenericDAO<DepartementSoc, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DepartementSocDAO";

}
