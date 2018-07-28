
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.CriticiteManagerLocal;
import com.teratech.gmao.core.ifaces.base.CriticiteManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CriticiteDAOLocal;
import com.teratech.gmao.model.base.Criticite;

@TransactionAttribute
@Stateless(mappedName = "CriticiteManager")
public class CriticiteManagerImpl
    extends AbstractGenericManager<Criticite, Long>
    implements CriticiteManagerLocal, CriticiteManagerRemote
{

    @EJB(name = "CriticiteDAO")
    protected CriticiteDAOLocal dao;

    public CriticiteManagerImpl() {
    }

    @Override
    public GenericDAO<Criticite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
