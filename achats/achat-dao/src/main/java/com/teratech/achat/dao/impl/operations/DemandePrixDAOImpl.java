
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.DemandePrixDAOLocal;
import com.teratech.achat.dao.ifaces.operations.DemandePrixDAORemote;
import com.teratech.achat.model.operations.DemandePrix;

@Stateless(mappedName = "DemandePrixDAO")
public class DemandePrixDAOImpl
    extends AbstractGenericDAO<DemandePrix, Long>
    implements DemandePrixDAOLocal, DemandePrixDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public DemandePrixDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandePrix> getManagedEntityClass() {
        return (DemandePrix.class);
    }

}
