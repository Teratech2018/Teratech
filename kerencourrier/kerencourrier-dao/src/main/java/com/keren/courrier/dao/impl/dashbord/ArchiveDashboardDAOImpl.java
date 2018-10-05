
package com.keren.courrier.dao.impl.dashbord;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.dashbord.ArchiveDashboardDAOLocal;
import com.keren.courrier.dao.ifaces.dashbord.ArchiveDashboardDAORemote;
import com.keren.courrier.model.dashbord.ArchiveDashboard;

@Stateless(mappedName = "ArchiveDashboardDAO")
public class ArchiveDashboardDAOImpl
    extends AbstractGenericDAO<ArchiveDashboard, Long>
    implements ArchiveDashboardDAOLocal, ArchiveDashboardDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ArchiveDashboardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ArchiveDashboard> getManagedEntityClass() {
        return (ArchiveDashboard.class);
    }

}
