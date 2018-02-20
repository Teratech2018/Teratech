
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ReductionDAO")
public class ReductionDAOImpl
    extends AbstractGenericDAO<Reduction, Long>
    implements ReductionDAOLocal, ReductionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ReductionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Reduction> getManagedEntityClass() {
        return (Reduction.class);
    }

}
