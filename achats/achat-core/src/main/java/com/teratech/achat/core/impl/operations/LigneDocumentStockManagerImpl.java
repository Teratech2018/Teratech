
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.LigneDocumentStockManagerLocal;
import com.teratech.achat.core.ifaces.operations.LigneDocumentStockManagerRemote;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentStockDAOLocal;
import com.teratech.achat.model.operations.LigneDocumentStock;

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
