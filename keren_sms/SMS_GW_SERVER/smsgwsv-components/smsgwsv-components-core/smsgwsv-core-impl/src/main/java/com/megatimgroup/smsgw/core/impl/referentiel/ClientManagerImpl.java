
package com.megatimgroup.smsgw.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ClientManagerLocal;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ClientManagerRemote;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ClientDAOLocal;
import com.megatimgroup.smsgw.model.referentiel.Client;

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
