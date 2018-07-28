
package com.teratech.gmao.dao.ifaces.budget;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.budget.BudgetEquipement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 21 17:19:17 GMT+01:00 2018
 * 
 */
public interface BudgetEquipementDAO
    extends GenericDAO<BudgetEquipement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BudgetEquipementDAO";

}
