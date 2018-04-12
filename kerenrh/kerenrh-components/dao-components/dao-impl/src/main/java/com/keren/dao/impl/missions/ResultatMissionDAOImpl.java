
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.ResultatMissionDAOLocal;
import com.keren.dao.ifaces.missions.ResultatMissionDAORemote;
import com.keren.model.missions.ResultatMission;

@Stateless(mappedName = "ResultatMissionDAO")
public class ResultatMissionDAOImpl
    extends AbstractGenericDAO<ResultatMission, Long>
    implements ResultatMissionDAOLocal, ResultatMissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ResultatMissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ResultatMission> getManagedEntityClass() {
        return (ResultatMission.class);
    }

}
