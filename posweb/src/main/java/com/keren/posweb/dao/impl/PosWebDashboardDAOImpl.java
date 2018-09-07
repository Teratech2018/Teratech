
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.PosWebDashboardDAOLocal;
import com.keren.posweb.dao.ifaces.PosWebDashboardDAORemote;
import com.keren.posweb.model.PosWebDashboard;

@Stateless(mappedName = "PosWebDashboardDAO")
public class PosWebDashboardDAOImpl
    extends AbstractGenericDAO<PosWebDashboard, Long>
    implements PosWebDashboardDAOLocal, PosWebDashboardDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public PosWebDashboardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PosWebDashboard> getManagedEntityClass() {
        return (PosWebDashboard.class);
    }

}
