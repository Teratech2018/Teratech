
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.MissionDAOLocal;
import com.keren.dao.ifaces.missions.MissionDAORemote;
import com.keren.model.missions.Mission;

@Stateless(mappedName = "MissionDAO")
public class MissionDAOImpl
    extends AbstractGenericDAO<Mission, Long>
    implements MissionDAOLocal, MissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Mission> getManagedEntityClass() {
        return (Mission.class);
    }

}
