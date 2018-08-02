
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.UserDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.UserDAORemote;
import com.keren.courrier.model.referentiel.User;

@Stateless(mappedName = "UserDAO")
public class UserDAOImpl
    extends AbstractGenericDAO<User, Long>
    implements UserDAOLocal, UserDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public UserDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<User> getManagedEntityClass() {
        return (User.class);
    }

}
