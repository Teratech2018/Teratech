
package com.basaccount.dao.ifaces.comptabilite;

import com.basaccount.model.comptabilite.Compte;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Dec 01 14:04:40 WAT 2017
 * 
 */
public interface CompteDAO
    extends GenericDAO<Compte, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CompteDAO";

}
