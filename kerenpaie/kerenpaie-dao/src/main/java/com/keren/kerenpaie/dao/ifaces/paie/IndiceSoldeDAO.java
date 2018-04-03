
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.IndiceSolde;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 30 15:55:02 GMT+01:00 2018
 * 
 */
public interface IndiceSoldeDAO
    extends GenericDAO<IndiceSolde, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "IndiceSoldeDAO";

}
