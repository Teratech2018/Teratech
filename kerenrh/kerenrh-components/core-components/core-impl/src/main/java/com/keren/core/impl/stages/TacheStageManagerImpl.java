
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.TacheStageManagerLocal;
import com.keren.core.ifaces.stages.TacheStageManagerRemote;
import com.keren.dao.ifaces.stages.TacheStageDAOLocal;
import com.keren.model.stages.TacheStage;

@TransactionAttribute
@Stateless(mappedName = "TacheStageManager")
public class TacheStageManagerImpl
    extends AbstractGenericManager<TacheStage, Long>
    implements TacheStageManagerLocal, TacheStageManagerRemote
{

    @EJB(name = "TacheStageDAO")
    protected TacheStageDAOLocal dao;

    public TacheStageManagerImpl() {
    }

    @Override
    public GenericDAO<TacheStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
