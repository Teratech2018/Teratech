
package com.teratech.vente.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.comptabilite.Acompte;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 09:17:45 WAT 2019
 * 
 */
public interface AcompteDAO
    extends GenericDAO<Acompte, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AcompteDAO";

}
