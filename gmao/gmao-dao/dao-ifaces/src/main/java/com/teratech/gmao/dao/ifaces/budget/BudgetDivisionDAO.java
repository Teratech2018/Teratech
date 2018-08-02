
package com.teratech.gmao.dao.ifaces.budget;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.budget.BudgetDivision;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 21 11:07:50 GMT+01:00 2018
 * 
 */
public interface BudgetDivisionDAO
    extends GenericDAO<BudgetDivision, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BudgetDivisionDAO";

}
