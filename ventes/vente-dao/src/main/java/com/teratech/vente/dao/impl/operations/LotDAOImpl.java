
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.LotDAOLocal;
import com.teratech.vente.dao.ifaces.operations.LotDAORemote;
import com.teratech.vente.model.operations.Lot;

@Stateless(mappedName = "LotDAO")
public class LotDAOImpl
    extends AbstractGenericDAO<Lot, Long>
    implements LotDAOLocal, LotDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
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
