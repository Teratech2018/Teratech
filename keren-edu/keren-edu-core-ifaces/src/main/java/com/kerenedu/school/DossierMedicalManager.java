
package com.kerenedu.school;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 28 15:02:40 WAT 2017
 * 
 */
public interface DossierMedicalManager
    extends GenericManager<DossierMedical, Long>
{

    public final static String SERVICE_NAME = "DossierMedicalManager";

}
