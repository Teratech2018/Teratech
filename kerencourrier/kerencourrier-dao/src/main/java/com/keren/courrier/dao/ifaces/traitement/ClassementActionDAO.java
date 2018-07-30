
package com.keren.courrier.dao.ifaces.traitement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.traitement.ClassementAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 27 09:58:14 GMT+01:00 2018
 * 
 */
public interface ClassementActionDAO
    extends GenericDAO<ClassementAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClassementActionDAO";

}
