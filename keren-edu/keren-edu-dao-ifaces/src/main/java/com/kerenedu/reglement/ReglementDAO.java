
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jan 22 15:28:57 WAT 2018
 * 
 */
public interface ReglementDAO
    extends GenericDAO<Reglement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ReglementDAO";

}
