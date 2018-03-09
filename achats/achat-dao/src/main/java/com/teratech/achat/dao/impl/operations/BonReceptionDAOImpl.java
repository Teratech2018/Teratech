
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAORemote;
import com.teratech.achat.model.operations.BonReception;

@Stateless(mappedName = "BonReceptionDAO")
public class BonReceptionDAOImpl
    extends AbstractGenericDAO<BonReception, Long>
    implements BonReceptionDAOLocal, BonReceptionDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public BonReceptionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BonReception> getManagedEntityClass() {
        return (BonReception.class);
    }

}
