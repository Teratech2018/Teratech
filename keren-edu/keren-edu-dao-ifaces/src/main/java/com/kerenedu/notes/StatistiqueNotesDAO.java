
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jan 16 12:36:33 WAT 2019
 * 
 */
public interface StatistiqueNotesDAO
    extends GenericDAO<StatistiqueNotes, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "StatistiqueNotesDAO";

}
