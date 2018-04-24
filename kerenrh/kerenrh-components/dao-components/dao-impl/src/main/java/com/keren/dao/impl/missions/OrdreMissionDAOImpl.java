
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.OrdreMissionDAOLocal;
import com.keren.dao.ifaces.missions.OrdreMissionDAORemote;
import com.keren.model.missions.OrdreMission;

@Stateless(mappedName = "OrdreMissionDAO")
public class OrdreMissionDAOImpl
    extends AbstractGenericDAO<OrdreMission, Long>
    implements OrdreMissionDAOLocal, OrdreMissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public OrdreMissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<OrdreMission> getManagedEntityClass() {
        return (OrdreMission.class);
    }

}
