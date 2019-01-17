
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 11 14:06:49 WAT 2019
 * 
 */
public interface BulletinHelper2DAO
    extends GenericDAO<BulletinHelper2, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinHelper2DAO";

}
