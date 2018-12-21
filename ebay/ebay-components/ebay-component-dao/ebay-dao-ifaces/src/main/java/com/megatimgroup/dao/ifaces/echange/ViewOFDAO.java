
package com.megatimgroup.dao.ifaces.echange;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.megatimgroup.model.echange.ViewOperationFinanciere;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface ViewOFDAO
    extends GenericDAO<ViewOperationFinanciere, String>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewOFDAO";
    
    public String getnextIdPP(String v$prefixe);

}
