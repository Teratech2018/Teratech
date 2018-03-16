
package com.basaccount.dao.ifaces.achats;

import com.basaccount.model.achats.NoteFrais;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 16 09:30:47 GMT+01:00 2018
 * 
 */
public interface NoteFraisDAO
    extends GenericDAO<NoteFrais, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NoteFraisDAO";

}
