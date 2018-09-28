
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Sep 14 16:06:51 WAT 2018
 * 
 */
public interface EltSalaireDAO
    extends GenericDAO<EltSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EltSalaireDAO";

}
