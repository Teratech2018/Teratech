
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.operations.DocumentStockManagerLocal;
import com.teratech.stock.core.ifaces.operations.DocumentStockManagerRemote;
import com.teratech.stock.dao.ifaces.operations.DocumentStockDAOLocal;
import com.teratech.stock.model.operations.DocumentStock;

@TransactionAttribute
@Stateless(mappedName = "DocumentStockManager")
public class DocumentStockManagerImpl
    extends AbstractGenericManager<DocumentStock, Long>
    implements DocumentStockManagerLocal, DocumentStockManagerRemote
{

    @EJB(name = "DocumentStockDAO")
    protected DocumentStockDAOLocal dao;

    public DocumentStockManagerImpl() {
    }

    @Override
    public GenericDAO<DocumentStock, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
