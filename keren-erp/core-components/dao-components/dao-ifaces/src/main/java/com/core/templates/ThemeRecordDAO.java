
package com.core.templates;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Aug 06 16:38:12 GMT+01:00 2018
 * 
 */
public interface ThemeRecordDAO
    extends GenericDAO<ThemeRecord, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ThemeRecordDAO";

}
