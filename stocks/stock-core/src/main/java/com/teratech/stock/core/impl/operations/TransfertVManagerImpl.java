
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.operations.TransfertVManagerLocal;
import com.teratech.stock.core.ifaces.operations.TransfertVManagerRemote;
import com.teratech.stock.dao.ifaces.operations.TransfertVDAOLocal;
import com.teratech.stock.model.operations.TransfertV;

@TransactionAttribute
@Stateless(mappedName = "TransfertVManager")
public class TransfertVManagerImpl
    extends AbstractGenericManager<TransfertV, Long>
    implements TransfertVManagerLocal, TransfertVManagerRemote
{

    @EJB(name = "TransfertVDAO")
    protected TransfertVDAOLocal dao;

    public TransfertVManagerImpl() {
    }

    @Override
    public GenericDAO<TransfertV, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
