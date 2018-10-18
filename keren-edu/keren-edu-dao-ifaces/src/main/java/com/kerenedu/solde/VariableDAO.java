
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 12:16:54 WAT 2018
 * 
 */
public interface VariableDAO
    extends GenericDAO<Variable, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "VariableDAO";

}
