
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.LotManagerLocal;
import com.teratech.gmao.core.ifaces.base.LotManagerRemote;
import com.teratech.gmao.dao.ifaces.base.LotDAOLocal;
import com.teratech.gmao.model.base.Lot;

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
