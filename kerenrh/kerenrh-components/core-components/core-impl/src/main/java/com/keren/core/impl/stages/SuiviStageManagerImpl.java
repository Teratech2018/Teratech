
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.SuiviStageManagerLocal;
import com.keren.core.ifaces.stages.SuiviStageManagerRemote;
import com.keren.dao.ifaces.stages.SuiviStageDAOLocal;
import com.keren.model.stages.SuiviStage;

@TransactionAttribute
@Stateless(mappedName = "SuiviStageManager")
public class SuiviStageManagerImpl
    extends AbstractGenericManager<SuiviStage, Long>
    implements SuiviStageManagerLocal, SuiviStageManagerRemote
{

    @EJB(name = "SuiviStageDAO")
    protected SuiviStageDAOLocal dao;

    public SuiviStageManagerImpl() {
    }

    @Override
    public GenericDAO<SuiviStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
