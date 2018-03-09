
package com.teratech.stock.core.ifaces.invetaire;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Feb 24 11:54:50 GMT+01:00 2018
 * 
 */
public interface LArticleEmplacementLotManager
    extends GenericManager<LArticleEmplacementLot, Long>
{

    public final static String SERVICE_NAME = "LArticleEmplacementLotManager";

}
