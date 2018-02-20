
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 09:44:41 CET 2018
 * 
 */
public interface CoefMatiereDetailManager
    extends GenericManager<CoefMatiereDetail, Long>
{

    public final static String SERVICE_NAME = "CoefMatiereDetailManager";

}
