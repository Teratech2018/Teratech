
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 16:18:26 WAT 2018
 * 
 */
public interface ElementVariableDAO
    extends GenericDAO<ElementVariable, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ElementVariableDAO";

}
