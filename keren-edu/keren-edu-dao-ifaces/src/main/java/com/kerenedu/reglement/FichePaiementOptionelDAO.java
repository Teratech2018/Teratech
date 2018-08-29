
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Aug 24 09:40:03 WAT 2018
 * 
 */
public interface FichePaiementOptionelDAO
    extends GenericDAO<FichePaiementOptionel, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FichePaiementOptionelDAO";

}
