
package com.teratech.gmao.dao.ifaces.curative;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.curative.AffectationBonTravail;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 17 13:30:30 GMT+01:00 2018
 * 
 */
public interface AffectationBonTravailDAO
    extends GenericDAO<AffectationBonTravail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AffectationBonTravailDAO";

}
