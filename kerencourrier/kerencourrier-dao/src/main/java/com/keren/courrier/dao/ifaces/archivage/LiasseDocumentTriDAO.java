
package com.keren.courrier.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.archivage.LiasseDocumentTri;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 28 10:45:51 WAT 2018
 * 
 */
public interface LiasseDocumentTriDAO
    extends GenericDAO<LiasseDocumentTri, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LiasseDocumentTriDAO";

}
