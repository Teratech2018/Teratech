
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LieuStageDAO")
public class LieuStageDAOImpl
    extends AbstractGenericDAO<LieuStage, Long>
    implements LieuStageDAOLocal, LieuStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LieuStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LieuStage> getManagedEntityClass() {
        return (LieuStage.class);
    }

}
