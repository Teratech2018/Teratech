
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri May 11 09:52:55 WAT 2018
 * 
 */
public interface ConsultationEchManager
    extends GenericManager<ConsultationEch, Long>
{

    public final static String SERVICE_NAME = "ConsultationEchManager";

}
