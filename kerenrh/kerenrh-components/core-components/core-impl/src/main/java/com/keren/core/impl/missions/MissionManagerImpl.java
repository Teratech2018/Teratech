
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.MissionManagerLocal;
import com.keren.core.ifaces.missions.MissionManagerRemote;
import com.keren.dao.ifaces.missions.MissionDAOLocal;
import com.keren.model.missions.Mission;

@TransactionAttribute
@Stateless(mappedName = "MissionManager")
public class MissionManagerImpl
    extends AbstractGenericManager<Mission, Long>
    implements MissionManagerLocal, MissionManagerRemote
{

    @EJB(name = "MissionDAO")
    protected MissionDAOLocal dao;

    public MissionManagerImpl() {
    }

    @Override
    public GenericDAO<Mission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
