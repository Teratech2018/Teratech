
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface LigneBulletinPaieDAO
    extends GenericDAO<LigneBulletinPaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneBulletinPaieDAO";

}
