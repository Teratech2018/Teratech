
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.EntreeDAORemote;
import com.teratech.achat.model.operations.Entree;

@Stateless(mappedName = "EntreeDAO")
public class EntreeDAOImpl
    extends AbstractGenericDAO<Entree, Long>
    implements EntreeDAOLocal, EntreeDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
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
