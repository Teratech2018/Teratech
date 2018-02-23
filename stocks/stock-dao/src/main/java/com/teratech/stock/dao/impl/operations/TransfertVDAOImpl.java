
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.TransfertVDAOLocal;
import com.teratech.stock.dao.ifaces.operations.TransfertVDAORemote;
import com.teratech.stock.model.operations.TransfertV;

@Stateless(mappedName = "TransfertVDAO")
public class TransfertVDAOImpl
    extends AbstractGenericDAO<TransfertV, Long>
    implements TransfertVDAOLocal, TransfertVDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public TransfertVDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TransfertV> getManagedEntityClass() {
        return (TransfertV.class);
    }

}
