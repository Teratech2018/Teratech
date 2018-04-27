
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 25 00:23:27 WAT 2018
 * 
 */
public interface BulletinHelperGenerateDAO
    extends GenericDAO<BulletinHelperGenerate, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinHelperGenerateDAO";

}
