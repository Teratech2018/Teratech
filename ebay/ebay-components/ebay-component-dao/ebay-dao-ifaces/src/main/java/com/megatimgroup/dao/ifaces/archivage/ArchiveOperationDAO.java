
package com.megatimgroup.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.megatimgroup.model.archivage.ArchiveOperation;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface ArchiveOperationDAO
    extends GenericDAO<ArchiveOperation, String>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ArchiveOperationDAO";
    

}
