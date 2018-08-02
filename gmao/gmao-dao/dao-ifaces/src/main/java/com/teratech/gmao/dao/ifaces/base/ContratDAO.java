
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Contrat;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 14 10:49:36 GMT+01:00 2018
 * 
 */
public interface ContratDAO
    extends GenericDAO<Contrat, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ContratDAO";

}
