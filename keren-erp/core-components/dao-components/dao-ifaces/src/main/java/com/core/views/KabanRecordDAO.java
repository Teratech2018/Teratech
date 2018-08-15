
package com.core.views;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 14 12:34:04 GMT+01:00 2018
 * 
 */
public interface KabanRecordDAO
    extends GenericDAO<KabanRecord, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "KabanRecordDAO";

}
