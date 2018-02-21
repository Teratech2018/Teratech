
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.TransfertDAOLocal;
import com.teratech.stock.dao.ifaces.operations.TransfertDAORemote;
import com.teratech.stock.model.operations.Transfert;

@Stateless(mappedName = "TransfertDAO")
public class TransfertDAOImpl
    extends AbstractGenericDAO<Transfert, Long>
    implements TransfertDAOLocal, TransfertDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public TransfertDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Transfert> getManagedEntityClass() {
        return (Transfert.class);
    }

}
