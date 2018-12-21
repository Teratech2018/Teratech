
package com.megatimgroup.core.impl.referentiels;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.referentiels.GroupeManager;
import com.megatimgroup.model.referentiels.Groupe;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class GroupeManagerImpl
    extends AbstractGenericManager<Groupe, String>
    implements GroupeManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.referentiels.GroupeDAOImpl")
    protected GenericDAO dao;

    public GroupeManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<Groupe, String> getDao() {
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
