
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TacheStageDAO")
public class TacheStageDAOImpl
    extends AbstractGenericDAO<TacheStage, Long>
    implements TacheStageDAOLocal, TacheStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TacheStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TacheStage> getManagedEntityClass() {
        return (TacheStage.class);
    }

}
