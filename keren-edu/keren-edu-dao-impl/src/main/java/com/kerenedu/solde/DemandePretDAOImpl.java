
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "DemandePretDAO")
public class DemandePretDAOImpl
    extends AbstractGenericDAO<DemandePret, Long>
    implements DemandePretDAOLocal, DemandePretDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandePretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandePret> getManagedEntityClass() {
        return (DemandePret.class);
    }

}
