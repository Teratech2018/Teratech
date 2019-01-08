
package com.teratech.vente.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.others.SendDevisForm;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 11:26:18 WAT 2019
 * 
 */
public interface SendDevisFormManager
    extends GenericManager<SendDevisForm, Long>
{

    public final static String SERVICE_NAME = "SendDevisFormManager";

}
