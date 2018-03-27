
package com.keren.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.employes.DepartementSocManagerLocal;
import com.keren.core.ifaces.employes.DepartementSocManagerRemote;
import com.keren.dao.ifaces.employes.DepartementSocDAOLocal;
import com.keren.model.employes.DepartementSoc;

@TransactionAttribute
@Stateless(mappedName = "DepartementSocManager")
public class DepartementSocManagerImpl
    extends AbstractGenericManager<DepartementSoc, Long>
    implements DepartementSocManagerLocal, DepartementSocManagerRemote
{

    @EJB(name = "DepartementSocDAO")
    protected DepartementSocDAOLocal dao;

    public DepartementSocManagerImpl() {
    }

    @Override
    public GenericDAO<DepartementSoc, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
