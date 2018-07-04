
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "AppreciationManager")
public class AppreciationManagerImpl
    extends AbstractGenericManager<Appreciation, Long>
    implements AppreciationManagerLocal, AppreciationManagerRemote
{

    @EJB(name = "AppreciationDAO")
    protected AppreciationDAOLocal dao;

    public AppreciationManagerImpl() {
    }

    @Override
    public GenericDAO<Appreciation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
