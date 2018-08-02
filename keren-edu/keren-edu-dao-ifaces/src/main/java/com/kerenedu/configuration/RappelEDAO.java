
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jun 26 10:30:40 WAT 2018
 * 
 */
public interface RappelEDAO
    extends GenericDAO<RappelE, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RappelEDAO";

}
