
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 18 21:27:11 WAT 2018
 * 
 */
public interface FraisScolaireDAO
    extends GenericDAO<FraisScolaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FraisScolaireDAO";

}
