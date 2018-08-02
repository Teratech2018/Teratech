
package com.teratech.gmao.core.ifaces.budget;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.budget.BudgetCentre;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 21 17:19:18 GMT+01:00 2018
 * 
 */
public interface BudgetCentreManager
    extends GenericManager<BudgetCentre, Long>
{

    public final static String SERVICE_NAME = "BudgetCentreManager";

}
