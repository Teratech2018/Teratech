
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Sep 10 15:39:10 WAT 2018
 * 
 */
public interface BulletinPaieDAO
    extends GenericDAO<BulletinPaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinPaieDAO";

}
