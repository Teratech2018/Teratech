
package com.megatimgroup.dao.impl.operations;

import javax.persistence.EntityManager;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.operations.BordereauBPDAO;
import com.megatimgroup.model.reporting.BordereauBP;


/**
 * Classe d'implementation de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class BordereauBPDAOImpl
    extends AbstractGenericDAO<BordereauBP, String>
    implements BordereauBPDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public BordereauBPDAOImpl() {
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
    public Class<BordereauBP> getManagedEntityClass() {
        return (BordereauBP.class);
    }

}
