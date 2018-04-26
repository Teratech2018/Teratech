
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 24 15:14:10 WAT 2018
 * 
 */
public interface LigneBulletinClasseDAO
    extends GenericDAO<LigneBulletinClasse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneBulletinClasseDAO";

}
