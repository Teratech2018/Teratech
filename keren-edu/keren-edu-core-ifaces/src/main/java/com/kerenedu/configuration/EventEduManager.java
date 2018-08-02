
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jun 25 10:28:19 WAT 2018
 * 
 */
public interface EventEduManager
    extends GenericManager<EventEdu, Long>
{

    public final static String SERVICE_NAME = "EventEduManager";

}
