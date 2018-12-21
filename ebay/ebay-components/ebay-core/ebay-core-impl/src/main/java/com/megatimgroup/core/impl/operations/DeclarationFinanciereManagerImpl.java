
package com.megatimgroup.core.impl.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.operations.DeclarationFinanciereManager;
import com.megatimgroup.model.operations.DeclarationFinanciere;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class DeclarationFinanciereManagerImpl
    extends AbstractGenericManager<DeclarationFinanciere, Long>
    implements DeclarationFinanciereManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.operations.DeclarationFinanciereDAOImpl")
    protected GenericDAO dao;

    public DeclarationFinanciereManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<DeclarationFinanciere, Long> getDao() {
        return dao;
    }

    /**
     * Methode permettant de retourner l'id de l'entite
     * 
     */
    @Override
    public String getEntityIdName() {
        return "id";
    }

}
