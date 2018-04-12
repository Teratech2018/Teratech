
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.OrdreMissionManagerLocal;
import com.keren.core.ifaces.missions.OrdreMissionManagerRemote;
import com.keren.dao.ifaces.missions.OrdreMissionDAOLocal;
import com.keren.model.missions.OrdreMission;

@TransactionAttribute
@Stateless(mappedName = "OrdreMissionManager")
public class OrdreMissionManagerImpl
    extends AbstractGenericManager<OrdreMission, Long>
    implements OrdreMissionManagerLocal, OrdreMissionManagerRemote
{

    @EJB(name = "OrdreMissionDAO")
    protected OrdreMissionDAOLocal dao;

    public OrdreMissionManagerImpl() {
    }

    @Override
    public GenericDAO<OrdreMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
