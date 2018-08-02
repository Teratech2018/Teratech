
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.TraitementCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 19 10:36:24 GMT+01:00 2018
 * 
 */
public interface TraitementCourrierDAO
    extends GenericDAO<TraitementCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TraitementCourrierDAO";

}
