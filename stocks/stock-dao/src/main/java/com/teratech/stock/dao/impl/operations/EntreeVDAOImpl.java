
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.EntreeVDAOLocal;
import com.teratech.stock.dao.ifaces.operations.EntreeVDAORemote;
import com.teratech.stock.model.operations.EntreeV;

@Stateless(mappedName = "EntreeVDAO")
public class EntreeVDAOImpl
    extends AbstractGenericDAO<EntreeV, Long>
    implements EntreeVDAOLocal, EntreeVDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public EntreeVDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EntreeV> getManagedEntityClass() {
        return (EntreeV.class);
    }

}
