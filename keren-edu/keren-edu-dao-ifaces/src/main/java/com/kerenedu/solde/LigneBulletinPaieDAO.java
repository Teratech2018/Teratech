
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 15:46:58 WAT 2018
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