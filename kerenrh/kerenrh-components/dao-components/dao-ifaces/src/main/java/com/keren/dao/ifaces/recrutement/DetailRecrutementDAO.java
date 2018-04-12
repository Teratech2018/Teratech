
package com.keren.dao.ifaces.recrutement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.recrutement.DetailRecrutement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface DetailRecrutementDAO
    extends GenericDAO<DetailRecrutement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DetailRecrutementDAO";

}
