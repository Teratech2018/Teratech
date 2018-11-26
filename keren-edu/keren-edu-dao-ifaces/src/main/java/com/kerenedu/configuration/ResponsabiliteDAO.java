
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface ResponsabiliteDAO
    extends GenericDAO<Responsabilite, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ResponsabiliteDAO";

}
