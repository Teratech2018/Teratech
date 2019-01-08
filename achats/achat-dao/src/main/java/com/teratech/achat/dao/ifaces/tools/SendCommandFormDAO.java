
package com.teratech.achat.dao.ifaces.tools;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.tools.SendCommandForm;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Feb 23 09:56:10 WAT 2018
 * 
 */
public interface SendCommandFormDAO
    extends GenericDAO<SendCommandForm, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SendCommandFormDAO";

}
