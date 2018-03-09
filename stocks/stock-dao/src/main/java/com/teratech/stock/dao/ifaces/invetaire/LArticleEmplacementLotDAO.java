
package com.teratech.stock.dao.ifaces.invetaire;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Feb 24 11:54:50 GMT+01:00 2018
 * 
 */
public interface LArticleEmplacementLotDAO
    extends GenericDAO<LArticleEmplacementLot, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LArticleEmplacementLotDAO";

}
