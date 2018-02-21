
package com.teratech.stock.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.base.EmplacementManagerLocal;
import com.teratech.stock.core.ifaces.base.EmplacementManagerRemote;
import com.teratech.stock.dao.ifaces.base.EmplacementDAOLocal;
import com.teratech.stock.model.base.Emplacement;

@TransactionAttribute
@Stateless(mappedName = "EmplacementManager")
public class EmplacementManagerImpl
    extends AbstractGenericManager<Emplacement, Long>
    implements EmplacementManagerLocal, EmplacementManagerRemote
{

    @EJB(name = "EmplacementDAO")
    protected EmplacementDAOLocal dao;

    public EmplacementManagerImpl() {
    }

    @Override
    public GenericDAO<Emplacement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
