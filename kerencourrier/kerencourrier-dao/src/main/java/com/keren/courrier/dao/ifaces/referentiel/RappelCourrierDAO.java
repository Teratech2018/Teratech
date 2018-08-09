
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.RappelCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 31 12:08:43 WAT 2018
 * 
 */
public interface RappelCourrierDAO
    extends GenericDAO<RappelCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RappelCourrierDAO";

}
