
package com.keren.courrier.dao.ifaces.traitement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.traitement.QuotationAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 26 18:00:17 GMT+01:00 2018
 * 
 */
public interface QuotationActionDAO
    extends GenericDAO<QuotationAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "QuotationActionDAO";

}
