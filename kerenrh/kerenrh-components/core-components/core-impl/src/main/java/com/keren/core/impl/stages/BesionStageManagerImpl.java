
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.BesionStageManagerLocal;
import com.keren.core.ifaces.stages.BesionStageManagerRemote;
import com.keren.dao.ifaces.stages.BesionStageDAOLocal;
import com.keren.model.stages.BesionStage;

@TransactionAttribute
@Stateless(mappedName = "BesionStageManager")
public class BesionStageManagerImpl
    extends AbstractGenericManager<BesionStage, Long>
    implements BesionStageManagerLocal, BesionStageManagerRemote
{

    @EJB(name = "BesionStageDAO")
    protected BesionStageDAOLocal dao;

    public BesionStageManagerImpl() {
    }

    @Override
    public GenericDAO<BesionStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
