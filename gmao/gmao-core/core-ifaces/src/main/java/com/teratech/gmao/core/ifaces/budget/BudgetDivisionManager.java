
package com.teratech.gmao.core.ifaces.budget;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.budget.BudgetDivision;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 21 11:07:51 GMT+01:00 2018
 * 
 */
public interface BudgetDivisionManager
    extends GenericManager<BudgetDivision, Long>
{

    public final static String SERVICE_NAME = "BudgetDivisionManager";

}
