
package com.keren.dao.impl.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.stages.EvaluationStageDAOLocal;
import com.keren.dao.ifaces.stages.EvaluationStageDAORemote;
import com.keren.model.stages.EvaluationStage;

@Stateless(mappedName = "EvaluationStageDAO")
public class EvaluationStageDAOImpl
    extends AbstractGenericDAO<EvaluationStage, Long>
    implements EvaluationStageDAOLocal, EvaluationStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EvaluationStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EvaluationStage> getManagedEntityClass() {
        return (EvaluationStage.class);
    }

}
