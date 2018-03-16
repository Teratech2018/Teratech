
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RetardDAO")
public class RetardDAOImpl
    extends AbstractGenericDAO<Retard, Long>
    implements RetardDAOLocal, RetardDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RetardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Retard> getManagedEntityClass() {
        return (Retard.class);
    }

}
