
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.FactureDAOLocal;
import com.teratech.achat.dao.ifaces.operations.FactureDAORemote;
import com.teratech.achat.model.operations.Facture;

@Stateless(mappedName = "FactureDAO")
public class FactureDAOImpl
    extends AbstractGenericDAO<Facture, Long>
    implements FactureDAOLocal, FactureDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public FactureDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Facture> getManagedEntityClass() {
        return (Facture.class);
    }

}
