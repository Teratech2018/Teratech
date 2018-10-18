
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 12:02:32 WAT 2018
 * 
 */
public interface LigneConvensionDAO
    extends GenericDAO<LigneConvension, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneConvensionDAO";

}
