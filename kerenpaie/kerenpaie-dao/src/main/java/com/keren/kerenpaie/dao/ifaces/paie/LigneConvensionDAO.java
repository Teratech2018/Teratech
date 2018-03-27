
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.LigneConvension;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Mar 06 14:40:10 GMT+01:00 2018
 * 
 */
public interface LigneConvensionDAO
    extends GenericDAO<LigneConvension, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneConvensionDAO";

}
