
package com.megatimgroup.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.megatimgroup.model.operations.DeclarationPM;


/**
 * Interface etendue par les interfaces locale et remote de la DAO

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface DeclarationPMDAO
    extends GenericDAO<DeclarationPM, String>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DeclarationPMDAO";
    

}
