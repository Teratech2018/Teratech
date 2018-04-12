
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.CategorieMissionManagerLocal;
import com.keren.core.ifaces.missions.CategorieMissionManagerRemote;
import com.keren.dao.ifaces.missions.CategorieMissionDAOLocal;
import com.keren.model.missions.CategorieMission;

@TransactionAttribute
@Stateless(mappedName = "CategorieMissionManager")
public class CategorieMissionManagerImpl
    extends AbstractGenericManager<CategorieMission, Long>
    implements CategorieMissionManagerLocal, CategorieMissionManagerRemote
{

    @EJB(name = "CategorieMissionDAO")
    protected CategorieMissionDAOLocal dao;

    public CategorieMissionManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
