
package com.keren.dao.impl.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.stages.StageDAOLocal;
import com.keren.dao.ifaces.stages.StageDAORemote;
import com.keren.model.stages.Stage;

@Stateless(mappedName = "StageDAO")
public class StageDAOImpl
    extends AbstractGenericDAO<Stage, Long>
    implements StageDAOLocal, StageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public StageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Stage> getManagedEntityClass() {
        return (Stage.class);
    }

}
