
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.FichierLieTri;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Aug 31 11:17:43 WAT 2018
 * 
 */
public interface FichierLieTriDAO
    extends GenericDAO<FichierLieTri, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FichierLieTriDAO";

}
