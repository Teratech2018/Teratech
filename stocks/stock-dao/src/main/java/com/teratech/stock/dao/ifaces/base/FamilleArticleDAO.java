
package com.teratech.stock.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.base.FamilleArticle;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Feb 19 16:55:36 GMT+01:00 2018
 * 
 */
public interface FamilleArticleDAO
    extends GenericDAO<FamilleArticle, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FamilleArticleDAO";

}
