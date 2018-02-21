
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.operations.LigneDocumentStockManagerLocal;
import com.teratech.stock.core.ifaces.operations.LigneDocumentStockManagerRemote;
import com.teratech.stock.dao.ifaces.operations.LigneDocumentStockDAOLocal;
import com.teratech.stock.model.operations.LigneDocumentStock;

@TransactionAttribute
@Stateless(mappedName = "LigneDocumentStockManager")
public class LigneDocumentStockManagerImpl
    extends AbstractGenericManager<LigneDocumentStock, Long>
    implements LigneDocumentStockManagerLocal, LigneDocumentStockManagerRemote
{

    @EJB(name = "LigneDocumentStockDAO")
    protected LigneDocumentStockDAOLocal dao;

    public LigneDocumentStockManagerImpl() {
    }

    @Override
    public GenericDAO<LigneDocumentStock, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
