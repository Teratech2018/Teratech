
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface RemboursementPretDAO
    extends GenericDAO<RemboursementPret, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RemboursementPretDAO";
	public long updateforce(String value);
}
