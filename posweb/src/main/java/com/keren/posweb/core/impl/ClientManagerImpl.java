
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.ClientManagerLocal;
import com.keren.posweb.core.ifaces.ClientManagerRemote;
import com.keren.posweb.dao.ifaces.ClientDAOLocal;
import com.keren.posweb.model.Client;

@TransactionAttribute
@Stateless(mappedName = "ClientManager")
public class ClientManagerImpl
    extends AbstractGenericManager<Client, Long>
    implements ClientManagerLocal, ClientManagerRemote
{

    @EJB(name = "ClientDAO")
    protected ClientDAOLocal dao;

    public ClientManagerImpl() {
    }

    @Override
    public GenericDAO<Client, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
