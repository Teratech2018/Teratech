
package com.kerenedu.stages;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 15:07:04 CET 2018
 * 
 */
public interface BesionStageDAO
    extends GenericDAO<BesionStage, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BesionStageDAO";

}
