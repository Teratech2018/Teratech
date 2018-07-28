
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.curative.PrioriteManagerLocal;
import com.teratech.gmao.core.ifaces.curative.PrioriteManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.PrioriteDAOLocal;
import com.teratech.gmao.model.curative.Priorite;

@TransactionAttribute
@Stateless(mappedName = "PrioriteManager")
public class PrioriteManagerImpl
    extends AbstractGenericManager<Priorite, Long>
    implements PrioriteManagerLocal, PrioriteManagerRemote
{

    @EJB(name = "PrioriteDAO")
    protected PrioriteDAOLocal dao;

    public PrioriteManagerImpl() {
    }

    @Override
    public GenericDAO<Priorite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
