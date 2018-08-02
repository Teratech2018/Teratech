
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.ClasseurCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 27 09:35:25 GMT+01:00 2018
 * 
 */
public interface ClasseurCourrierDAO
    extends GenericDAO<ClasseurCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClasseurCourrierDAO";

}
