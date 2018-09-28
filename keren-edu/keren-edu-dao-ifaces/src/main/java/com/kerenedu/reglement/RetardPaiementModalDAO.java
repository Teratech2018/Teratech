
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Sep 04 10:23:04 WAT 2018
 * 
 */
public interface RetardPaiementModalDAO
    extends GenericDAO<RetardPaiementModal, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RetardPaiementModalDAO";

}
