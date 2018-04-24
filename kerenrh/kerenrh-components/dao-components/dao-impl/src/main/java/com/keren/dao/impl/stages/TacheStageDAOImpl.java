
package com.keren.dao.impl.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.stages.TacheStageDAOLocal;
import com.keren.dao.ifaces.stages.TacheStageDAORemote;
import com.keren.model.stages.TacheStage;

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
