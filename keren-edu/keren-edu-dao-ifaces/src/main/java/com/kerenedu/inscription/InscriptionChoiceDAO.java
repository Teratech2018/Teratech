
package com.kerenedu.inscription;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Sep 04 13:51:28 WAT 2018
 * 
 */
public interface InscriptionChoiceDAO
    extends GenericDAO<InscriptionChoice, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "InscriptionChoiceDAO";

}
