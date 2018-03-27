
package com.keren.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.employes.FamilleManagerLocal;
import com.keren.core.ifaces.employes.FamilleManagerRemote;
import com.keren.dao.ifaces.employes.FamilleDAOLocal;
import com.keren.model.employes.Famille;

@TransactionAttribute
@Stateless(mappedName = "FamilleManager")
public class FamilleManagerImpl
    extends AbstractGenericManager<Famille, Long>
    implements FamilleManagerLocal, FamilleManagerRemote
{

    @EJB(name = "FamilleDAO")
    protected FamilleDAOLocal dao;

    public FamilleManagerImpl() {
    }

    @Override
    public GenericDAO<Famille, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
