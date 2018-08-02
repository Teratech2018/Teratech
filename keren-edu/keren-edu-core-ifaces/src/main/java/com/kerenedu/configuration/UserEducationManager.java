
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jun 25 11:58:13 WAT 2018
 * 
 */
public interface UserEducationManager
    extends GenericManager<UserEducation, Long>
{

    public final static String SERVICE_NAME = "UserEducationManager";

}
