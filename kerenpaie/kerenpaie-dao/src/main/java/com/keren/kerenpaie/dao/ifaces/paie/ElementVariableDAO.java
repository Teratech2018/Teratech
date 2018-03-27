
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.ElementVariable;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Mar 17 12:54:25 GMT+01:00 2018
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
