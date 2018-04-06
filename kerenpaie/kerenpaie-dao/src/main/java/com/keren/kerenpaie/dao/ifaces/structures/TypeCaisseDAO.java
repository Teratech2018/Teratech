
package com.keren.kerenpaie.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.structures.TypeCaisse;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Apr 05 13:54:58 GMT+01:00 2018
 * 
 */
public interface TypeCaisseDAO
    extends GenericDAO<TypeCaisse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TypeCaisseDAO";

}
