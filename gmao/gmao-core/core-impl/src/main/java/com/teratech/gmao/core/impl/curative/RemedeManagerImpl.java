
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.curative.RemedeManagerLocal;
import com.teratech.gmao.core.ifaces.curative.RemedeManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.RemedeDAOLocal;
import com.teratech.gmao.model.curative.Remede;

@TransactionAttribute
@Stateless(mappedName = "RemedeManager")
public class RemedeManagerImpl
    extends AbstractGenericManager<Remede, Long>
    implements RemedeManagerLocal, RemedeManagerRemote
{

    @EJB(name = "RemedeDAO")
    protected RemedeDAOLocal dao;

    public RemedeManagerImpl() {
    }

    @Override
    public GenericDAO<Remede, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
