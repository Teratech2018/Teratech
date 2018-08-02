
package com.teratech.gmao.core.ifaces.budget;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.budget.LigneBudgetSaisie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 21 12:58:34 GMT+01:00 2018
 * 
 */
public interface LigneBudgetSaisieManager
    extends GenericManager<LigneBudgetSaisie, Long>
{

    public final static String SERVICE_NAME = "LigneBudgetSaisieManager";

}
