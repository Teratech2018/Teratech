
package com.megatimgroup.dao.impl.referentiels;

import javax.persistence.EntityManager;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.referentiels.StatusResidenceDAO;
import com.megatimgroup.model.referentiels.StatusResidence;


/**
 * Classe d'implementation de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class StatusResidenceDAOImpl
    extends AbstractGenericDAO<StatusResidence, String>
    implements StatusResidenceDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public StatusResidenceDAOImpl() {
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
    public Class<StatusResidence> getManagedEntityClass() {
        return (StatusResidence.class);
    }

}
