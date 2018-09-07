
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.UniteAchat;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
 * 
 */
public interface UniteAchatDAO
    extends GenericDAO<UniteAchat, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UniteAchatDAO";

}
