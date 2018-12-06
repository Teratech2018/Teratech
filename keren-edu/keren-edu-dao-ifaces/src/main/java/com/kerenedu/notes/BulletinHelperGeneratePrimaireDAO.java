
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 06 02:40:55 WAT 2018
 * 
 */
public interface BulletinHelperGeneratePrimaireDAO
    extends GenericDAO<BulletinHelperGeneratePrimaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinHelperGeneratePrimaireDAO";

}
