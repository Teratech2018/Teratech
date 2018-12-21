
package com.megatimgroup.dao.impl.referentiels;

import javax.persistence.EntityManager;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.referentiels.DivisionDAO;
import com.megatimgroup.model.referentiels.Division;


/**
 * Classe d'implementation de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class DivisionDAOImpl
    extends AbstractGenericDAO<Division, String>
    implements DivisionDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public DivisionDAOImpl() {
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
    public Class<Division> getManagedEntityClass() {
        return (Division.class);
    }

}
