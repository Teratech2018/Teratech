
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.ActionMissionManagerLocal;
import com.keren.core.ifaces.missions.ActionMissionManagerRemote;
import com.keren.dao.ifaces.missions.ActionMissionDAOLocal;
import com.keren.model.missions.ActionMission;

@TransactionAttribute
@Stateless(mappedName = "ActionMissionManager")
public class ActionMissionManagerImpl
    extends AbstractGenericManager<ActionMission, Long>
    implements ActionMissionManagerLocal, ActionMissionManagerRemote
{

    @EJB(name = "ActionMissionDAO")
    protected ActionMissionDAOLocal dao;

    public ActionMissionManagerImpl() {
    }

    @Override
    public GenericDAO<ActionMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
