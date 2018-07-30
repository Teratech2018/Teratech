
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierClone;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 27 15:52:41 GMT+01:00 2018
 * 
 */
public interface CourrierCloneDAO
    extends GenericDAO<CourrierClone, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierCloneDAO";
    
    public long deleteCourrierRAD(CourrierClone entity) ;

}
