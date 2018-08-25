
package com.keren.portailweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.portailweb.dao.ifaces.PortailWebDashboardDAOLocal;
import com.keren.portailweb.dao.ifaces.PortailWebDashboardDAORemote;
import com.keren.portailweb.model.PortailWebDashboard;

@Stateless(mappedName = "PortailWebDashboardDAO")
public class PortailWebDashboardDAOImpl
    extends AbstractGenericDAO<PortailWebDashboard, Long>
    implements PortailWebDashboardDAOLocal, PortailWebDashboardDAORemote
{

    @PersistenceContext(unitName = "portailweb")
    protected EntityManager em;

    public PortailWebDashboardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PortailWebDashboard> getManagedEntityClass() {
        return (PortailWebDashboard.class);
    }

}
