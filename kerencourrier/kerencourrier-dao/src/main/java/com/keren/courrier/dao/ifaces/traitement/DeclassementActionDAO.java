
package com.keren.courrier.dao.ifaces.traitement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.traitement.DeclassementAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Aug 01 17:08:48 GMT+01:00 2018
 * 
 */
public interface DeclassementActionDAO
    extends GenericDAO<DeclassementAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DeclassementActionDAO";

}
