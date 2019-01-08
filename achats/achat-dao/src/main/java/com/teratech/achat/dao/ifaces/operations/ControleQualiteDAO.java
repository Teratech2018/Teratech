
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.ControleQualite;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Feb 24 14:57:20 WAT 2018
 * 
 */
public interface ControleQualiteDAO
    extends GenericDAO<ControleQualite, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ControleQualiteDAO";

}
