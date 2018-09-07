
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.ClientDAOLocal;
import com.keren.posweb.dao.ifaces.ClientDAORemote;
import com.keren.posweb.model.Client;

@Stateless(mappedName = "ClientDAO")
public class ClientDAOImpl
    extends AbstractGenericDAO<Client, Long>
    implements ClientDAOLocal, ClientDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public ClientDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Client> getManagedEntityClass() {
        return (Client.class);
    }

}
