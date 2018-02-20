
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Feb 12 14:00:56 CET 2018
 * 
 */
public interface GroupeCoursManager
    extends GenericManager<GroupeCours, Long>
{

    public final static String SERVICE_NAME = "GroupeCoursManager";

}
