
package com.teratech.gmao.dao.ifaces.preventif;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.preventif.MiseAJourCompteur;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 16 20:45:16 GMT+01:00 2018
 * 
 */
public interface MiseAJourCompteurDAO
    extends GenericDAO<MiseAJourCompteur, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "MiseAJourCompteurDAO";

}
