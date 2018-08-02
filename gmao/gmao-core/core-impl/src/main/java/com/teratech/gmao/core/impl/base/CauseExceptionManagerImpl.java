
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.CauseExceptionManagerLocal;
import com.teratech.gmao.core.ifaces.base.CauseExceptionManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CauseExceptionDAOLocal;
import com.teratech.gmao.model.base.CauseException;

@TransactionAttribute
@Stateless(mappedName = "CauseExceptionManager")
public class CauseExceptionManagerImpl
    extends AbstractGenericManager<CauseException, Long>
    implements CauseExceptionManagerLocal, CauseExceptionManagerRemote
{

    @EJB(name = "CauseExceptionDAO")
    protected CauseExceptionDAOLocal dao;

    public CauseExceptionManagerImpl() {
    }

    @Override
    public GenericDAO<CauseException, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
