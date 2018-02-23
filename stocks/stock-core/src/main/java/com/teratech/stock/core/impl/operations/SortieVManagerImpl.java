
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.operations.SortieVManagerLocal;
import com.teratech.stock.core.ifaces.operations.SortieVManagerRemote;
import com.teratech.stock.dao.ifaces.operations.SortieVDAOLocal;
import com.teratech.stock.model.operations.SortieV;

@TransactionAttribute
@Stateless(mappedName = "SortieVManager")
public class SortieVManagerImpl
    extends AbstractGenericManager<SortieV, Long>
    implements SortieVManagerLocal, SortieVManagerRemote
{

    @EJB(name = "SortieVDAO")
    protected SortieVDAOLocal dao;

    public SortieVManagerImpl() {
    }

    @Override
    public GenericDAO<SortieV, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
