
package com.kerenedu.dashboard;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ViewDashboardDAO")
public class ViewDashboardDAOImpl
    extends AbstractGenericDAO<ViewDashboard, Long>
    implements ViewDashboardDAOLocal, ViewDashboardDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewDashboardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewDashboard> getManagedEntityClass() {
        return (ViewDashboard.class);
    }

}
