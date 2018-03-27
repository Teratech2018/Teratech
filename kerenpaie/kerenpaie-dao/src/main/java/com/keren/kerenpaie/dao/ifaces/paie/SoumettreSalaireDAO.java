
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Mar 13 15:58:30 GMT+01:00 2018
 * 
 */
public interface SoumettreSalaireDAO
    extends GenericDAO<SoumettreSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SoumettreSalaireDAO";

}
