
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.PosSession;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Sep 05 17:03:54 GMT+01:00 2018
 * 
 */
public interface PosSessionDAO
    extends GenericDAO<PosSession, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PosSessionDAO";

}
