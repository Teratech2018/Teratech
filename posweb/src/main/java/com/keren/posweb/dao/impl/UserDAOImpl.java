
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.UserDAOLocal;
import com.keren.posweb.dao.ifaces.UserDAORemote;
import com.keren.posweb.model.User;

@Stateless(mappedName = "UserDAO")
public class UserDAOImpl
    extends AbstractGenericDAO<User, Long>
    implements UserDAOLocal, UserDAORemote
{

    @PersistenceContext(unitName = "posweb")
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
