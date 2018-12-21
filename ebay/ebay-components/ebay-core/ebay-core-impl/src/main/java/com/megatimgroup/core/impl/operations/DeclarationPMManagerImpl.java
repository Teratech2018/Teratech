
package com.megatimgroup.core.impl.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.operations.DeclarationPMManager;
import com.megatimgroup.model.operations.DeclarationPM;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class DeclarationPMManagerImpl
    extends AbstractGenericManager<DeclarationPM, String>
    implements DeclarationPMManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.operations.DeclarationPMDAOImpl")
    protected GenericDAO dao;

    public DeclarationPMManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<DeclarationPM, String> getDao() {
        return dao;
    }

    /**
     * Methode permettant de retourner l'id de l'entite
     * 
     */
    @Override
    public String getEntityIdName() {
        return "reference";
    }

}
