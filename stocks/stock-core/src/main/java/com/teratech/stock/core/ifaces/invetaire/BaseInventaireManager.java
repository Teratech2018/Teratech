
package com.teratech.stock.core.ifaces.invetaire;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.invetaire.BaseInventaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 19:29:43 GMT+01:00 2018
 * 
 */
public interface BaseInventaireManager
    extends GenericManager<BaseInventaire, Long>
{

    public final static String SERVICE_NAME = "BaseInventaireManager";

}
