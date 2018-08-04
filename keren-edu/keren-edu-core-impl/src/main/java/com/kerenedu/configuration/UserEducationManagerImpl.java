
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "UserEducationManager")
public class UserEducationManagerImpl
    extends AbstractGenericManager<UserEducation, Long>
    implements UserEducationManagerLocal, UserEducationManagerRemote
{

    @EJB(name = "UserEducationDAO")
    protected UserEducationDAOLocal dao;

    public UserEducationManagerImpl() {
    }

    @Override
    public GenericDAO<UserEducation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
