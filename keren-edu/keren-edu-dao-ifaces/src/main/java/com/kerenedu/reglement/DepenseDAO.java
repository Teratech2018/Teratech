
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sun Jul 08 15:59:49 WAT 2018
 * 
 */
public interface DepenseDAO
    extends GenericDAO<Depense, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DepenseDAO";

}
