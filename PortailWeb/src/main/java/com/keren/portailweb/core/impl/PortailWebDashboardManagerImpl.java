
package com.keren.portailweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.portailweb.core.ifaces.PortailWebDashboardManagerLocal;
import com.keren.portailweb.core.ifaces.PortailWebDashboardManagerRemote;
import com.keren.portailweb.dao.ifaces.PortailWebDashboardDAOLocal;
import com.keren.portailweb.model.PortailWebDashboard;

@TransactionAttribute
@Stateless(mappedName = "PortailWebDashboardManager")
public class PortailWebDashboardManagerImpl
    extends AbstractGenericManager<PortailWebDashboard, Long>
    implements PortailWebDashboardManagerLocal, PortailWebDashboardManagerRemote
{

    @EJB(name = "PortailWebDashboardDAO")
    protected PortailWebDashboardDAOLocal dao;

    public PortailWebDashboardManagerImpl() {
    }

    @Override
    public GenericDAO<PortailWebDashboard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
