
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

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
