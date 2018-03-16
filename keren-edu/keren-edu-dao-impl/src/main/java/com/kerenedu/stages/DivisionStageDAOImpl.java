
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "DivisionStageDAO")
public class DivisionStageDAOImpl
    extends AbstractGenericDAO<DivisionStage, Long>
    implements DivisionStageDAOLocal, DivisionStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DivisionStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DivisionStage> getManagedEntityClass() {
        return (DivisionStage.class);
    }

}
