
package com.kerenedu.stages;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 21:14:57 CET 2018
 * 
 */
public interface StageEDAO
    extends GenericDAO<StageE, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "StageEDAO";

}
