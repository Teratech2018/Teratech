
package com.keren.courrier.dao.ifaces.traitement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.traitement.RelanceAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 31 08:24:47 WAT 2018
 * 
 */
public interface RelanceActionDAO
    extends GenericDAO<RelanceAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RelanceActionDAO";

}
