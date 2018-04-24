
package com.keren.dao.impl.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.stages.LivrableStageDAOLocal;
import com.keren.dao.ifaces.stages.LivrableStageDAORemote;
import com.keren.model.stages.LivrableStage;

@Stateless(mappedName = "LivrableStageDAO")
public class LivrableStageDAOImpl
    extends AbstractGenericDAO<LivrableStage, Long>
    implements LivrableStageDAOLocal, LivrableStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LivrableStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LivrableStage> getManagedEntityClass() {
        return (LivrableStage.class);
    }

}
