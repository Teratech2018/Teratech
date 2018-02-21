
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.stock.dao.ifaces.operations.EntreeDAORemote;
import com.teratech.stock.model.operations.Entree;

@Stateless(mappedName = "EntreeDAO")
public class EntreeDAOImpl
    extends AbstractGenericDAO<Entree, Long>
    implements EntreeDAOLocal, EntreeDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public EntreeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Entree> getManagedEntityClass() {
        return (Entree.class);
    }

}
