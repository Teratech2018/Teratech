
package com.teratech.achat.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 27 15:19:45 WAT 2018
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
