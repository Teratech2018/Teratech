
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 17 17:53:09 WAT 2018
 * 
 */
public interface RemiseDAO
    extends GenericDAO<Remise, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RemiseDAO";

}
