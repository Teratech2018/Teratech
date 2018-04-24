
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.IndicateurPerformanceDAOLocal;
import com.keren.dao.ifaces.missions.IndicateurPerformanceDAORemote;
import com.keren.model.missions.IndicateurPerformance;

@Stateless(mappedName = "IndicateurPerformanceDAO")
public class IndicateurPerformanceDAOImpl
    extends AbstractGenericDAO<IndicateurPerformance, Long>
    implements IndicateurPerformanceDAOLocal, IndicateurPerformanceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public IndicateurPerformanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<IndicateurPerformance> getManagedEntityClass() {
        return (IndicateurPerformance.class);
    }

}
