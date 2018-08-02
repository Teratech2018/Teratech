
package com.teratech.gmao.dao.ifaces.budget;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.budget.LigneBudgetSaisie;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 21 12:58:33 GMT+01:00 2018
 * 
 */
public interface LigneBudgetSaisieDAO
    extends GenericDAO<LigneBudgetSaisie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneBudgetSaisieDAO";

}
