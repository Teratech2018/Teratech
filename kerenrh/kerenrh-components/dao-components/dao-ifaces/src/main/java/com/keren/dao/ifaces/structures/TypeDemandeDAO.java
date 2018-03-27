
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.TypeDemande;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 13:58:01 GMT+01:00 2018
 * 
 */
public interface TypeDemandeDAO
    extends GenericDAO<TypeDemande, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TypeDemandeDAO";

}
