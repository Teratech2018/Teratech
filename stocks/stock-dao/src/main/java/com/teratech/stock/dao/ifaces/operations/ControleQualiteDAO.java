
package com.teratech.stock.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.operations.ControleQualite;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Dec 29 13:22:54 WAT 2018
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
