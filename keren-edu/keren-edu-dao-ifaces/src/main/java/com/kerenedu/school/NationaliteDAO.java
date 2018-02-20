
package com.kerenedu.school;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 28 15:02:40 WAT 2017
 * 
 */
public interface NationaliteDAO
    extends GenericDAO<Nationalite, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NationaliteDAO";

}
