
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.CategorieModuleManagerLocal;
import com.keren.core.ifaces.formations.CategorieModuleManagerRemote;
import com.keren.dao.ifaces.formations.CategorieModuleDAOLocal;
import com.keren.model.formations.CategorieModule;

@TransactionAttribute
@Stateless(mappedName = "CategorieModuleManager")
public class CategorieModuleManagerImpl
    extends AbstractGenericManager<CategorieModule, Long>
    implements CategorieModuleManagerLocal, CategorieModuleManagerRemote
{

    @EJB(name = "CategorieModuleDAO")
    protected CategorieModuleDAOLocal dao;

    public CategorieModuleManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieModule, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
