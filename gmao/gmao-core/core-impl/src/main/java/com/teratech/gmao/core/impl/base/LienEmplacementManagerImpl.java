
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.LienEmplacementManagerLocal;
import com.teratech.gmao.core.ifaces.base.LienEmplacementManagerRemote;
import com.teratech.gmao.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.gmao.model.base.LienEmplacement;

@TransactionAttribute
@Stateless(mappedName = "LienEmplacementManager")
public class LienEmplacementManagerImpl
    extends AbstractGenericManager<LienEmplacement, Long>
    implements LienEmplacementManagerLocal, LienEmplacementManagerRemote
{

    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal dao;

    public LienEmplacementManagerImpl() {
    }

    @Override
    public GenericDAO<LienEmplacement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
