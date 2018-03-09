
package com.teratech.achat.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.comptabilite.EcheanceReglement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Mar 05 23:39:42 GMT+01:00 2018
 * 
 */
public interface EcheanceReglementDAO
    extends GenericDAO<EcheanceReglement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EcheanceReglementDAO";

}
