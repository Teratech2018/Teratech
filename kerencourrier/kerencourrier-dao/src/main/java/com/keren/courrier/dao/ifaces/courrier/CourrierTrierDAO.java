
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierTrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 28 17:51:17 WAT 2018
 * 
 */
public interface CourrierTrierDAO
    extends GenericDAO<CourrierTrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierTrierDAO";

}
