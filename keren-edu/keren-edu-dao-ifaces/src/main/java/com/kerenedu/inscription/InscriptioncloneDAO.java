
package com.kerenedu.inscription;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Aug 08 06:03:35 WAT 2018
 * 
 */
public interface InscriptioncloneDAO
    extends GenericDAO<Inscriptionclone, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "InscriptioncloneDAO";

}
