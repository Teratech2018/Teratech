
package com.keren.courrier.core.ifaces.traitement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.traitement.QuotationAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 26 18:00:17 GMT+01:00 2018
 * 
 */
public interface QuotationActionManager
    extends GenericManager<QuotationAction, Long>
{

    public final static String SERVICE_NAME = "QuotationActionManager";

}
