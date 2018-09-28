
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.UniteAchatManagerLocal;
import com.keren.posweb.core.ifaces.UniteAchatManagerRemote;
import com.keren.posweb.dao.ifaces.UniteAchatDAOLocal;
import com.keren.posweb.model.UniteAchat;

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
