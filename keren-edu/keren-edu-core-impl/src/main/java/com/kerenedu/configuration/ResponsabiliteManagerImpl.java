
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ResponsabiliteManager")
public class ResponsabiliteManagerImpl
    extends AbstractGenericManager<Responsabilite, Long>
    implements ResponsabiliteManagerLocal, ResponsabiliteManagerRemote
{

    @EJB(name = "ResponsabiliteDAO")
    protected ResponsabiliteDAOLocal dao;

    public ResponsabiliteManagerImpl() {
    }

    @Override
    public GenericDAO<Responsabilite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
