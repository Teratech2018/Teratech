
package com.keren.core.impl.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.stages.EvaluationStageManagerLocal;
import com.keren.core.ifaces.stages.EvaluationStageManagerRemote;
import com.keren.dao.ifaces.stages.EvaluationStageDAOLocal;
import com.keren.model.stages.EvaluationStage;

@TransactionAttribute
@Stateless(mappedName = "EvaluationStageManager")
public class EvaluationStageManagerImpl
    extends AbstractGenericManager<EvaluationStage, Long>
    implements EvaluationStageManagerLocal, EvaluationStageManagerRemote
{

    @EJB(name = "EvaluationStageDAO")
    protected EvaluationStageDAOLocal dao;

    public EvaluationStageManagerImpl() {
    }

    @Override
    public GenericDAO<EvaluationStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
