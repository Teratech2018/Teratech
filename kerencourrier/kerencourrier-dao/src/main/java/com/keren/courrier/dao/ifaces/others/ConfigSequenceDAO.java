
package com.keren.courrier.dao.ifaces.others;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.others.ConfigSequence;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Sep 24 14:52:55 WAT 2018
 * 
 */
public interface ConfigSequenceDAO
    extends GenericDAO<ConfigSequence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ConfigSequenceDAO";

}
