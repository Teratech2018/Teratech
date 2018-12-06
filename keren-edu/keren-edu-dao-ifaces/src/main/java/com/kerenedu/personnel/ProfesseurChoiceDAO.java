
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Nov 27 16:21:12 WAT 2018
 * 
 */
public interface ProfesseurChoiceDAO
    extends GenericDAO<ProfesseurChoice, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ProfesseurChoiceDAO";

}
