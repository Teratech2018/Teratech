
package com.keren.courrier.dao.ifaces.traitement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.traitement.AnnotationAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 26 18:30:41 GMT+01:00 2018
 * 
 */
public interface AnnotationActionDAO
    extends GenericDAO<AnnotationAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AnnotationActionDAO";

}
