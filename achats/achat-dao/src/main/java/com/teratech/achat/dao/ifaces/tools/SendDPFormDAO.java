
package com.teratech.achat.dao.ifaces.tools;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.tools.SendDPForm;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Dec 22 07:37:50 WAT 2018
 * 
 */
public interface SendDPFormDAO
    extends GenericDAO<SendDPForm, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SendDPFormDAO";

}
