
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.CompartimentClasseur;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 27 09:35:25 GMT+01:00 2018
 * 
 */
public interface CompartimentClasseurDAO
    extends GenericDAO<CompartimentClasseur, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CompartimentClasseurDAO";

}
