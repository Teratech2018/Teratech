
package com.keren.courrier.dao.impl.dashbord;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.dashbord.CourrierDashboardDAOLocal;
import com.keren.courrier.dao.ifaces.dashbord.CourrierDashboardDAORemote;
import com.keren.courrier.model.dashbord.CourrierDashboard;

@Stateless(mappedName = "CourrierDashboardDAO")
public class CourrierDashboardDAOImpl
    extends AbstractGenericDAO<CourrierDashboard, Long>
    implements CourrierDashboardDAOLocal, CourrierDashboardDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierDashboardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierDashboard> getManagedEntityClass() {
        return (CourrierDashboard.class);
    }

}
