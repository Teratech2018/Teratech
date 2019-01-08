
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.LigneReponseDP;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Dec 22 14:01:05 WAT 2018
 * 
 */
public interface LigneReponseDPDAO
    extends GenericDAO<LigneReponseDP, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneReponseDPDAO";

}
