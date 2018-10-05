
package com.keren.courrier.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.archivage.ArchiveLiasse;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Aug 31 11:37:36 WAT 2018
 * 
 */
public interface ArchiveLiasseDAO
    extends GenericDAO<ArchiveLiasse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ArchiveLiasseDAO";

}
