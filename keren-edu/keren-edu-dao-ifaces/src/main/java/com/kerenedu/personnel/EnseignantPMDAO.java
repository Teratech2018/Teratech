
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface EnseignantPMDAO
    extends GenericDAO<EnseignantPM, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EnseignantPMDAO";

}
