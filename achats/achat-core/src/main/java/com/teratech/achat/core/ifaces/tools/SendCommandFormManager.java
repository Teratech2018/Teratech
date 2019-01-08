
package com.teratech.achat.core.ifaces.tools;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.tools.SendCommandForm;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Feb 23 09:56:11 WAT 2018
 * 
 */
public interface SendCommandFormManager
    extends GenericManager<SendCommandForm, Long>
{

    public final static String SERVICE_NAME = "SendCommandFormManager";

}
