
package com.keren.kerenpaie.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.structures.Syndicat;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Apr 05 13:54:58 GMT+01:00 2018
 * 
 */
public interface SyndicatDAO
    extends GenericDAO<Syndicat, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SyndicatDAO";

}
