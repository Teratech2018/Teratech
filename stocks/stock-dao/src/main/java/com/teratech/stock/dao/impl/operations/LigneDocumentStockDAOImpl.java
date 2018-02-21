
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.LigneDocumentStockDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LigneDocumentStockDAORemote;
import com.teratech.stock.model.operations.LigneDocumentStock;

@Stateless(mappedName = "LigneDocumentStockDAO")
public class LigneDocumentStockDAOImpl
    extends AbstractGenericDAO<LigneDocumentStock, Long>
    implements LigneDocumentStockDAOLocal, LigneDocumentStockDAORemote
{

    @PersistenceContext(unitName = "teratech")
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
