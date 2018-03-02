
package com.teratech.achat.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.base.FamilleArticle;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 27 14:29:37 GMT+01:00 2018
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
