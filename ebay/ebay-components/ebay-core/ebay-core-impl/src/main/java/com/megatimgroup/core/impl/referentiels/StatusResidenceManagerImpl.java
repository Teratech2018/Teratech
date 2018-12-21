
package com.megatimgroup.core.impl.referentiels;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.referentiels.StatusResidenceManager;
import com.megatimgroup.model.referentiels.StatusResidence;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class StatusResidenceManagerImpl
    extends AbstractGenericManager<StatusResidence, String>
    implements StatusResidenceManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.referentiels.StatusResidenceDAOImpl")
    protected GenericDAO dao;

    public StatusResidenceManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<StatusResidence, String> getDao() {
        return dao;
    }

    /**
     * Methode permettant de retourner l'id de l'entite
     * 
     */
    @Override
    public String getEntityIdName() {
        return "code";
    }

}
