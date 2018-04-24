
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.ActionMissionDAOLocal;
import com.keren.dao.ifaces.missions.ActionMissionDAORemote;
import com.keren.model.missions.ActionMission;

@Stateless(mappedName = "ActionMissionDAO")
public class ActionMissionDAOImpl
    extends AbstractGenericDAO<ActionMission, Long>
    implements ActionMissionDAOLocal, ActionMissionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ActionMissionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ActionMission> getManagedEntityClass() {
        return (ActionMission.class);
    }

}
