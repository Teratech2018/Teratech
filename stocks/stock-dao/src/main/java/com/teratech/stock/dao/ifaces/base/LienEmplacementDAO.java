
package com.teratech.stock.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.base.LienEmplacement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Dec 29 19:27:06 WAT 2018
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
