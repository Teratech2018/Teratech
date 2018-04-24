
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.notes.NoteDetail;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface AppreciationDAO
    extends GenericDAO<Appreciation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AppreciationDAO";
    
    public Appreciation getAppreciation(NoteDetail entiy);

}
