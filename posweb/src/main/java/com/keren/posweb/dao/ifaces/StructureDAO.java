
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.Structure;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Sep 05 17:03:54 GMT+01:00 2018
 * 
 */
public interface StructureDAO
    extends GenericDAO<Structure, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "StructureDAO";

}
