
package com.teratech.gmao.core.ifaces.budget;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.budget.BudgetEquipement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 21 17:19:18 GMT+01:00 2018
 * 
 */
public interface BudgetEquipementManager
    extends GenericManager<BudgetEquipement, Long>
{

    public final static String SERVICE_NAME = "BudgetEquipementManager";

}
