
package com.megatimgroup.dao.impl.parametres;

import javax.persistence.EntityManager;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.parametres.SocieteDAO;
import com.megatimgroup.model.parametres.Societe;


/**
 * Classe d'implementation de la DAO

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class SocieteDAOImpl
    extends AbstractGenericDAO<Societe, Long>
    implements SocieteDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public SocieteDAOImpl() {
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
    public Class<Societe> getManagedEntityClass() {
        return (Societe.class);
    }

}
