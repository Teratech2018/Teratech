
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.UserManagerLocal;
import com.keren.posweb.core.ifaces.UserManagerRemote;
import com.keren.posweb.dao.ifaces.UserDAOLocal;
import com.keren.posweb.model.User;

@TransactionAttribute
@Stateless(mappedName = "UserManager")
public class UserManagerImpl
    extends AbstractGenericManager<User, Long>
    implements UserManagerLocal, UserManagerRemote
{

    @EJB(name = "UserDAO")
    protected UserDAOLocal dao;

    public UserManagerImpl() {
    }

    @Override
    public GenericDAO<User, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
