
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.BorderoCourrierR;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 28 11:15:08 GMT+01:00 2018
 * 
 */
public interface BorderoCourrierRDAO
    extends GenericDAO<BorderoCourrierR, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BorderoCourrierRDAO";

}
