
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 09 15:21:42 WAT 2018
 * 
 */
public interface AnneScolaireDAO
    extends GenericDAO<AnneScolaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AnneScolaireDAO";
    
    public AnneScolaire getAnneScolaireCourante() ;

}
