
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 31 16:32:02 WAT 2019
 * 
 */
public interface ClasseSecondaireManager
    extends GenericManager<ClasseSecondaire, Long>
{

    public final static String SERVICE_NAME = "ClasseSecondaireManager";

}
