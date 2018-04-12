
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.FraisMissionManagerLocal;
import com.keren.core.ifaces.missions.FraisMissionManagerRemote;
import com.keren.dao.ifaces.missions.FraisMissionDAOLocal;
import com.keren.model.missions.FraisMission;

@TransactionAttribute
@Stateless(mappedName = "FraisMissionManager")
public class FraisMissionManagerImpl
    extends AbstractGenericManager<FraisMission, Long>
    implements FraisMissionManagerLocal, FraisMissionManagerRemote
{

    @EJB(name = "FraisMissionDAO")
    protected FraisMissionDAOLocal dao;

    public FraisMissionManagerImpl() {
    }

    @Override
    public GenericDAO<FraisMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
