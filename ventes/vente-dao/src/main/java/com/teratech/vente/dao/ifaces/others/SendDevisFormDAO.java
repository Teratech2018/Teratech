
package com.teratech.vente.dao.ifaces.others;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.others.SendDevisForm;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 11:26:17 WAT 2019
 * 
 */
public interface SendDevisFormDAO
    extends GenericDAO<SendDevisForm, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SendDevisFormDAO";

}
