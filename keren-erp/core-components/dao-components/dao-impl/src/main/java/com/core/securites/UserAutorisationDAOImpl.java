
package com.core.securites;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "UserAutorisationDAO")
public class UserAutorisationDAOImpl
    extends AbstractGenericDAO<UserAutorisation, Long>
    implements UserAutorisationDAOLocal, UserAutorisationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public UserAutorisationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UserAutorisation> getManagedEntityClass() {
        return (UserAutorisation.class);
    }

}
