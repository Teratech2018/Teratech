
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.Devis;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 10:14:00 WAT 2019
 * 
 */
public interface DevisDAO
    extends GenericDAO<Devis, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DevisDAO";

}
