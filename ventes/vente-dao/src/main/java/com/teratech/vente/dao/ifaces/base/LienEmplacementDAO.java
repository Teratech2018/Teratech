
package com.teratech.vente.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 09:17:45 WAT 2019
 * 
 */
public interface LienEmplacementDAO
    extends GenericDAO<LienEmplacement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LienEmplacementDAO";

}
