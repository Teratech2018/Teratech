
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.FamilleArticle;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
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
