
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 27 16:56:32 GMT+01:00 2018
 * 
 */
public interface LigneBorderoCourrierDAO
    extends GenericDAO<LigneBorderoCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneBorderoCourrierDAO";

}
