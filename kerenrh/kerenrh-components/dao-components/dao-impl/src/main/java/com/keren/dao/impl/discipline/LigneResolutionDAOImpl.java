
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.LigneResolutionDAOLocal;
import com.keren.dao.ifaces.discipline.LigneResolutionDAORemote;
import com.keren.model.discipline.LigneResolution;

@Stateless(mappedName = "LigneResolutionDAO")
public class LigneResolutionDAOImpl
    extends AbstractGenericDAO<LigneResolution, Long>
    implements LigneResolutionDAOLocal, LigneResolutionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneResolutionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneResolution> getManagedEntityClass() {
        return (LigneResolution.class);
    }

}
