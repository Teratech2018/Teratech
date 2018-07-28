
package com.teratech.gmao.dao.ifaces.curative;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.curative.BonTravail;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 16 08:49:28 GMT+01:00 2018
 * 
 */
public interface BonTravailDAO
    extends GenericDAO<BonTravail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BonTravailDAO";

}
