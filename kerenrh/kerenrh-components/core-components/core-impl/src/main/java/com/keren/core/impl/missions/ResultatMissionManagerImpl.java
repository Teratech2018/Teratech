
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.ResultatMissionManagerLocal;
import com.keren.core.ifaces.missions.ResultatMissionManagerRemote;
import com.keren.dao.ifaces.missions.ResultatMissionDAOLocal;
import com.keren.model.missions.ResultatMission;

@TransactionAttribute
@Stateless(mappedName = "ResultatMissionManager")
public class ResultatMissionManagerImpl
    extends AbstractGenericManager<ResultatMission, Long>
    implements ResultatMissionManagerLocal, ResultatMissionManagerRemote
{

    @EJB(name = "ResultatMissionDAO")
    protected ResultatMissionDAOLocal dao;

    public ResultatMissionManagerImpl() {
    }

    @Override
    public GenericDAO<ResultatMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
