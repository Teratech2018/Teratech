
package com.keren.kerenpaie.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.comptabilite.JournalComptable;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Mar 21 14:00:16 GMT+01:00 2018
 * 
 */
public interface JournalComptableDAO
    extends GenericDAO<JournalComptable, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "JournalComptableDAO";

}
