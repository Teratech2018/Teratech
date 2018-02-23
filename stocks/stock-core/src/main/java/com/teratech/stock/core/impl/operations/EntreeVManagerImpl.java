
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.operations.EntreeVManagerLocal;
import com.teratech.stock.core.ifaces.operations.EntreeVManagerRemote;
import com.teratech.stock.dao.ifaces.operations.EntreeVDAOLocal;
import com.teratech.stock.model.operations.EntreeV;

@TransactionAttribute
@Stateless(mappedName = "EntreeVManager")
public class EntreeVManagerImpl
    extends AbstractGenericManager<EntreeV, Long>
    implements EntreeVManagerLocal, EntreeVManagerRemote
{

    @EJB(name = "EntreeVDAO")
    protected EntreeVDAOLocal dao;

    public EntreeVManagerImpl() {
    }

    @Override
    public GenericDAO<EntreeV, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
