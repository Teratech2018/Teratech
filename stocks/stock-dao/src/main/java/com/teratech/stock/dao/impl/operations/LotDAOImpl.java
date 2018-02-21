
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAORemote;
import com.teratech.stock.model.operations.Lot;

@Stateless(mappedName = "LotDAO")
public class LotDAOImpl
    extends AbstractGenericDAO<Lot, Long>
    implements LotDAOLocal, LotDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public LotDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Lot> getManagedEntityClass() {
        return (Lot.class);
    }

}
