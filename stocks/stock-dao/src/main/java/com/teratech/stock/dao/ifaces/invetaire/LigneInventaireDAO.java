
package com.teratech.stock.dao.ifaces.invetaire;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.invetaire.LigneInventaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 20 19:29:42 GMT+01:00 2018
 * 
 */
public interface LigneInventaireDAO
    extends GenericDAO<LigneInventaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneInventaireDAO";

}
