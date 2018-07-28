
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Classe;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 14 12:31:43 GMT+01:00 2018
 * 
 */
public interface ClasseDAO
    extends GenericDAO<Classe, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClasseDAO";

}
