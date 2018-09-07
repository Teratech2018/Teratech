
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.PointVente;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Sep 05 10:26:16 GMT+01:00 2018
 * 
 */
public interface PointVenteDAO
    extends GenericDAO<PointVente, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PointVenteDAO";

}
