
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.LivrableStageManagerLocal;
import com.keren.core.ifaces.stages.LivrableStageManagerRemote;
import com.keren.dao.ifaces.stages.LivrableStageDAOLocal;
import com.keren.model.stages.LivrableStage;

@TransactionAttribute
@Stateless(mappedName = "LivrableStageManager")
public class LivrableStageManagerImpl
    extends AbstractGenericManager<LivrableStage, Long>
    implements LivrableStageManagerLocal, LivrableStageManagerRemote
{

    @EJB(name = "LivrableStageDAO")
    protected LivrableStageDAOLocal dao;

    public LivrableStageManagerImpl() {
    }

    @Override
    public GenericDAO<LivrableStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
