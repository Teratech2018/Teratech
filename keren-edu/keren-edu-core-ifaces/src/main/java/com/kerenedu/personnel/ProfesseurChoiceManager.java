
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Nov 27 16:21:12 WAT 2018
 * 
 */
public interface ProfesseurChoiceManager
    extends GenericManager<ProfesseurChoice, Long>
{

    public final static String SERVICE_NAME = "ProfesseurChoiceManager";

}
