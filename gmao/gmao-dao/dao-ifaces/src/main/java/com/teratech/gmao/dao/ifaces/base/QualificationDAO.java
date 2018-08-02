
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Qualification;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 14 11:42:34 GMT+01:00 2018
 * 
 */
public interface QualificationDAO
    extends GenericDAO<Qualification, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "QualificationDAO";

}
