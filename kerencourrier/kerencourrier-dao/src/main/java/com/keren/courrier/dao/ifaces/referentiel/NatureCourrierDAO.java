
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.NatureCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jul 18 14:02:05 GMT+01:00 2018
 * 
 */
public interface NatureCourrierDAO
    extends GenericDAO<NatureCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NatureCourrierDAO";

}
