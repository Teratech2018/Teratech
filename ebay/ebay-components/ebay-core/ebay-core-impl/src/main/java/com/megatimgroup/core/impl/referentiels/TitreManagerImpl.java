
package com.megatimgroup.core.impl.referentiels;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.core.ifaces.referentiels.TitreManager;
import com.megatimgroup.model.referentiels.Titre;


/**
 * Classe d'implementation du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
@Transaction
public class TitreManagerImpl
    extends AbstractGenericManager<Titre, String>
    implements TitreManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.dao.impl.referentiels.TitreDAOImpl")
    protected GenericDAO dao;

    public TitreManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<Titre, String> getDao() {
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
