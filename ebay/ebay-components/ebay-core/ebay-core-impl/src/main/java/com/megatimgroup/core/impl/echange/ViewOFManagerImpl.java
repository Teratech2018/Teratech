
package com.megatimgroup.core.impl.echange;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.echange.ViewOFManager;
import com.megatimgroup.model.echange.ViewOperationFinanciere;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class ViewOFManagerImpl
    extends AbstractGenericManager<ViewOperationFinanciere, String>
    implements ViewOFManager 
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.echange.ViewOFDAOImpl")
    protected GenericDAO dao;

    public ViewOFManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<ViewOperationFinanciere, String> getDao() {
        return dao;
    }

    /**
     * Methode permettant de retourner l'id de l'entite
     * 
     */
    @Override
    public String getEntityIdName() {
        return "idOperation";
    }

}
