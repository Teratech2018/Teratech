
package com.keren.dao.ifaces.formations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.formations.GenererBesionFormation;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 11 15:59:27 GMT+01:00 2018
 * 
 */
public interface GenererBesionFormationDAO
    extends GenericDAO<GenererBesionFormation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "GenererBesionFormationDAO";

}
