
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Oct 17 04:12:38 WAT 2018
 * 
 */
public interface ProfesseurcloneDAO
    extends GenericDAO<Professeurclone, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ProfesseurcloneDAO";

}
