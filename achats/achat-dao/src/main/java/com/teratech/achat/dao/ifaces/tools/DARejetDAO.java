
package com.teratech.achat.dao.ifaces.tools;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.tools.DARejet;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Dec 21 15:08:09 WAT 2018
 * 
 */
public interface DARejetDAO
    extends GenericDAO<DARejet, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DARejetDAO";

}
