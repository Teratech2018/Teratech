
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.StageManagerLocal;
import com.keren.core.ifaces.stages.StageManagerRemote;
import com.keren.dao.ifaces.stages.StageDAOLocal;
import com.keren.model.stages.Stage;

@TransactionAttribute
@Stateless(mappedName = "StageManager")
public class StageManagerImpl
    extends AbstractGenericManager<Stage, Long>
    implements StageManagerLocal, StageManagerRemote
{

    @EJB(name = "StageDAO")
    protected StageDAOLocal dao;

    public StageManagerImpl() {
    }

    @Override
    public GenericDAO<Stage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
