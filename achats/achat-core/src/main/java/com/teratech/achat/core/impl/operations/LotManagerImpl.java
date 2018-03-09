
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.LotManagerLocal;
import com.teratech.achat.core.ifaces.operations.LotManagerRemote;
import com.teratech.achat.dao.ifaces.operations.LotDAOLocal;
import com.teratech.achat.model.operations.Lot;

@TransactionAttribute
@Stateless(mappedName = "LotManager")
public class LotManagerImpl
    extends AbstractGenericManager<Lot, Long>
    implements LotManagerLocal, LotManagerRemote
{

    @EJB(name = "LotDAO")
    protected LotDAOLocal dao;

    public LotManagerImpl() {
    }

    @Override
    public GenericDAO<Lot, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
