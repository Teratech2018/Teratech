
package com.keren.courrier.core.impl.dashbord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.dashbord.CourrierDashboardManagerLocal;
import com.keren.courrier.core.ifaces.dashbord.CourrierDashboardManagerRemote;
import com.keren.courrier.dao.ifaces.dashbord.CourrierDashboardDAOLocal;
import com.keren.courrier.model.dashbord.CourrierDashboard;

@TransactionAttribute
@Stateless(mappedName = "CourrierDashboardManager")
public class CourrierDashboardManagerImpl
    extends AbstractGenericManager<CourrierDashboard, Long>
    implements CourrierDashboardManagerLocal, CourrierDashboardManagerRemote
{

    @EJB(name = "CourrierDashboardDAO")
    protected CourrierDashboardDAOLocal dao;

    public CourrierDashboardManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierDashboard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
