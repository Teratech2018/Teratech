
package com.megatimgroup.smsgw.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ClientDAOLocal;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ClientDAORemote;
import com.megatimgroup.smsgw.model.referentiel.Client;

@Stateless(mappedName = "ClientDAO")
public class ClientDAOImpl
    extends AbstractGenericDAO<Client, Long>
    implements ClientDAOLocal, ClientDAORemote
{

    @PersistenceContext(unitName = "smsgw")
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
