
package com.keren.dao.ifaces.recrutement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.recrutement.EtapeRecrutement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface EtapeRecrutementDAO
    extends GenericDAO<EtapeRecrutement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EtapeRecrutementDAO";

}
