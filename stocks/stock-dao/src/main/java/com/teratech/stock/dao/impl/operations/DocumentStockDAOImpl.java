
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.DocumentStockDAOLocal;
import com.teratech.stock.dao.ifaces.operations.DocumentStockDAORemote;
import com.teratech.stock.model.operations.DocumentStock;

@Stateless(mappedName = "DocumentStockDAO")
public class DocumentStockDAOImpl
    extends AbstractGenericDAO<DocumentStock, Long>
    implements DocumentStockDAOLocal, DocumentStockDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public DocumentStockDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DocumentStock> getManagedEntityClass() {
        return (DocumentStock.class);
    }

}
