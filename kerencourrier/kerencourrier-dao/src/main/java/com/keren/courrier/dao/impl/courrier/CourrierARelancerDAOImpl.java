
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierARelancerDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierARelancerDAORemote;
import com.keren.courrier.model.courrier.CourrierARelancer;

@Stateless(mappedName = "CourrierARelancerDAO")
public class CourrierARelancerDAOImpl
    extends AbstractGenericDAO<CourrierARelancer, Long>
    implements CourrierARelancerDAOLocal, CourrierARelancerDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierARelancerDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierARelancer> getManagedEntityClass() {
        return (CourrierARelancer.class);
    }

}
