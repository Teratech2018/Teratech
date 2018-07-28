
package com.teratech.gmao.dao.ifaces.curative;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.curative.ActiviteHBT;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 16 17:19:56 GMT+01:00 2018
 * 
 */
public interface ActiviteHBTDAO
    extends GenericDAO<ActiviteHBT, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ActiviteHBTDAO";

}
