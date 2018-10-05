
package com.keren.courrier.core.impl.dashbord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.dashbord.ArchiveDashboardManagerLocal;
import com.keren.courrier.core.ifaces.dashbord.ArchiveDashboardManagerRemote;
import com.keren.courrier.dao.ifaces.dashbord.ArchiveDashboardDAOLocal;
import com.keren.courrier.model.dashbord.ArchiveDashboard;

@TransactionAttribute
@Stateless(mappedName = "ArchiveDashboardManager")
public class ArchiveDashboardManagerImpl
    extends AbstractGenericManager<ArchiveDashboard, Long>
    implements ArchiveDashboardManagerLocal, ArchiveDashboardManagerRemote
{

    @EJB(name = "ArchiveDashboardDAO")
    protected ArchiveDashboardDAOLocal dao;

    public ArchiveDashboardManagerImpl() {
    }

    @Override
    public GenericDAO<ArchiveDashboard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
