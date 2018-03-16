
package com.kerenedu.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "StageEDAO")
public class StageEDAOImpl
    extends AbstractGenericDAO<StageE, Long>
    implements StageEDAOLocal, StageEDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public StageEDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<StageE> getManagedEntityClass() {
        return (StageE.class);
    }

}
