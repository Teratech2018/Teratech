
package com.keren.courrier.dao.ifaces.others;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.others.ViewCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Aug 01 14:46:35 GMT+01:00 2018
 * 
 */
public interface ViewCourrierDAO
    extends GenericDAO<ViewCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewCourrierDAO";

}
