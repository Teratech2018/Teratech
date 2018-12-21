
package com.megatimgroup.core.impl.parametres;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.parametres.SocieteManager;
import com.megatimgroup.model.parametres.Societe;


/**
 * Classe d'implementation du manager

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class SocieteManagerImpl
    extends AbstractGenericManager<Societe, Long>
    implements SocieteManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.parametres.SocieteDAOImpl")
    protected GenericDAO dao;

    public SocieteManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<Societe, Long> getDao() {
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
