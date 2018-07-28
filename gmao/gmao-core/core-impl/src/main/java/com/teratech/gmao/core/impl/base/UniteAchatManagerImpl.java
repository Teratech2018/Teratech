
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.UniteAchatManagerLocal;
import com.teratech.gmao.core.ifaces.base.UniteAchatManagerRemote;
import com.teratech.gmao.dao.ifaces.base.UniteAchatDAOLocal;
import com.teratech.gmao.model.base.UniteAchat;

@TransactionAttribute
@Stateless(mappedName = "UniteAchatManager")
public class UniteAchatManagerImpl
    extends AbstractGenericManager<UniteAchat, Long>
    implements UniteAchatManagerLocal, UniteAchatManagerRemote
{

    @EJB(name = "UniteAchatDAO")
    protected UniteAchatDAOLocal dao;

    public UniteAchatManagerImpl() {
    }

    @Override
    public GenericDAO<UniteAchat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
