
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Rubrique;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 14 15:15:31 GMT+01:00 2018
 * 
 */
public interface RubriqueDAO
    extends GenericDAO<Rubrique, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RubriqueDAO";

}
