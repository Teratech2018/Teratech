
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 31 16:32:02 WAT 2019
 * 
 */
public interface ClasseSecondaireDAO
    extends GenericDAO<ClasseSecondaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClasseSecondaireDAO";

}
