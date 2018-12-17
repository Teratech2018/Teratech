
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 06 15:23:28 WAT 2018
 * 
 */
public interface EmargementPeriodeDAO
    extends GenericDAO<EmargementPeriode, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EmargementPeriodeDAO";

}
