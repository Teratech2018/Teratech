
package com.teratech.vente.dao.ifaces.banques;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.banques.Banque;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 08:13:34 WAT 2019
 * 
 */
public interface BanqueDAO
    extends GenericDAO<Banque, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BanqueDAO";

}
