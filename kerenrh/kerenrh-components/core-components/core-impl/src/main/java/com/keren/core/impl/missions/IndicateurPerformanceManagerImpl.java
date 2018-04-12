
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerLocal;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerRemote;
import com.keren.dao.ifaces.missions.IndicateurPerformanceDAOLocal;
import com.keren.model.missions.IndicateurPerformance;

@TransactionAttribute
@Stateless(mappedName = "IndicateurPerformanceManager")
public class IndicateurPerformanceManagerImpl
    extends AbstractGenericManager<IndicateurPerformance, Long>
    implements IndicateurPerformanceManagerLocal, IndicateurPerformanceManagerRemote
{

    @EJB(name = "IndicateurPerformanceDAO")
    protected IndicateurPerformanceDAOLocal dao;

    public IndicateurPerformanceManagerImpl() {
    }

    @Override
    public GenericDAO<IndicateurPerformance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
