
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentStockDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentStockDAORemote;
import com.teratech.achat.model.operations.LigneDocumentStock;

@Stateless(mappedName = "LigneDocumentStockDAO")
public class LigneDocumentStockDAOImpl
    extends AbstractGenericDAO<LigneDocumentStock, Long>
    implements LigneDocumentStockDAOLocal, LigneDocumentStockDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public LigneDocumentStockDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneDocumentStock> getManagedEntityClass() {
        return (LigneDocumentStock.class);
    }

}
