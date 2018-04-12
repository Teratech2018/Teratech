
package com.keren.dao.impl.stages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.stages.BesionStageDAOLocal;
import com.keren.dao.ifaces.stages.BesionStageDAORemote;
import com.keren.model.stages.BesionStage;

@Stateless(mappedName = "BesionStageDAO")
public class BesionStageDAOImpl
    extends AbstractGenericDAO<BesionStage, Long>
    implements BesionStageDAOLocal, BesionStageDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BesionStageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BesionStage> getManagedEntityClass() {
        return (BesionStage.class);
    }

}
