
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 12 18:30:40 WAT 2018
 * 
 */
public interface SectionEDAO
    extends GenericDAO<SectionE, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SectionEDAO";

}
