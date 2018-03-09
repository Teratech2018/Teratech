
package com.kerenedu.stages;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 09 15:56:30 CET 2018
 * 
 */
public interface SuiviStageEleveDAO
    extends GenericDAO<SuiviStageEleve, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SuiviStageEleveDAO";

}
