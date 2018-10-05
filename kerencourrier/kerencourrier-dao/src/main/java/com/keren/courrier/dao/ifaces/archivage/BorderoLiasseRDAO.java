
package com.keren.courrier.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.archivage.BorderoLiasseR;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 28 09:06:49 WAT 2018
 * 
 */
public interface BorderoLiasseRDAO
    extends GenericDAO<BorderoLiasseR, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BorderoLiasseRDAO";

}
