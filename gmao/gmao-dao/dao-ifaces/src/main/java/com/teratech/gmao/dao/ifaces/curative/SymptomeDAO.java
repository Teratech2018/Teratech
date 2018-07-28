
package com.teratech.gmao.dao.ifaces.curative;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.curative.Symptome;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sun Jul 15 11:56:39 GMT+01:00 2018
 * 
 */
public interface SymptomeDAO
    extends GenericDAO<Symptome, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SymptomeDAO";

}
