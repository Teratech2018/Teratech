
package com.megatimgroup.dao.impl.operations;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.operations.DeclarationPPDAO;
import com.megatimgroup.model.operations.DeclarationPP;
import javax.persistence.EntityManager;


/**
 * Classe d'implementation de la DAO

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class DeclarationPPDAOImpl
    extends AbstractGenericDAO<DeclarationPP, String>
    implements DeclarationPPDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public DeclarationPPDAOImpl() {
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Methode permettant de retourner la classe de l'entite
     * 
     */
    @Override
    public Class<DeclarationPP> getManagedEntityClass() {
        return (DeclarationPP.class);
    }

}
