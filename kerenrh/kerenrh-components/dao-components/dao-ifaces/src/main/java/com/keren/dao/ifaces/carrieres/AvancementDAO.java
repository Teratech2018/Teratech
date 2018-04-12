
package com.keren.dao.ifaces.carrieres;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.carrieres.Avancement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface AvancementDAO
    extends GenericDAO<Avancement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AvancementDAO";

}
