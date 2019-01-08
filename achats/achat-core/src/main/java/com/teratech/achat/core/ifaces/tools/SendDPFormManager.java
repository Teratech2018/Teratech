
package com.teratech.achat.core.ifaces.tools;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.tools.SendDPForm;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Dec 22 07:37:51 WAT 2018
 * 
 */
public interface SendDPFormManager
    extends GenericManager<SendDPForm, Long>
{

    public final static String SERVICE_NAME = "SendDPFormManager";

}
