
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 20 10:17:15 WAT 2018
 * 
 */
public interface HelpProfClasseDAO
    extends GenericDAO<HelpProfClasse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "HelpProfClasseDAO";

}
