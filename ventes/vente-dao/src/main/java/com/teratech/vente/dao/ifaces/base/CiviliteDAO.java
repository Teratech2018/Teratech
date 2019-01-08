
package com.teratech.vente.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.base.Civilite;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 08:13:34 WAT 2019
 * 
 */
public interface CiviliteDAO
    extends GenericDAO<Civilite, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CiviliteDAO";

}
