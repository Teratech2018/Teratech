
package com.megatimgroup.dao.impl.parametres;

import javax.persistence.EntityManager;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.parametres.UserDAO;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.parametres.User;


/**
 * Classe d'implementation de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class UserDAOImpl
    extends AbstractGenericDAO<User, String>
    implements UserDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public UserDAOImpl() {
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
    public Class<User> getManagedEntityClass() {
        return (User.class);
    }

}
