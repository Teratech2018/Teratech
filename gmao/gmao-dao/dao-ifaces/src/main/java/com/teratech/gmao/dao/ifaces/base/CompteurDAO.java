
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Compteur;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 13 17:11:00 GMT+01:00 2018
 * 
 */
public interface CompteurDAO
    extends GenericDAO<Compteur, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CompteurDAO";

}
