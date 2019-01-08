
package com.teratech.vente.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.base.Pays;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 08:13:34 WAT 2019
 * 
 */
public interface PaysDAO
    extends GenericDAO<Pays, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PaysDAO";

}
