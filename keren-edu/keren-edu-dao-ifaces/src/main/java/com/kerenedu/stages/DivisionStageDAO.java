
package com.kerenedu.stages;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 09 13:39:29 CET 2018
 * 
 */
public interface DivisionStageDAO
    extends GenericDAO<DivisionStage, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DivisionStageDAO";

}
