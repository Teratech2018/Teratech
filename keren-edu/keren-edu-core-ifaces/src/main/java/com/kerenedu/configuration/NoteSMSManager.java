
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 08 11:01:56 CET 2018
 * 
 */
public interface NoteSMSManager
    extends GenericManager<NoteSMS, Long>
{

    public final static String SERVICE_NAME = "NoteSMSManager";
    

}
