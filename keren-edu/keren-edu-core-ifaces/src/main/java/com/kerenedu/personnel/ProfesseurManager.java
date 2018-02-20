
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
public interface ProfesseurManager
    extends GenericManager<Professeur, Long>
{

    public final static String SERVICE_NAME = "ProfesseurManager";

}
