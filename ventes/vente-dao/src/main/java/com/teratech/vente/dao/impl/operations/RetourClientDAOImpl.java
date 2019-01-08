
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.RetourClientDAOLocal;
import com.teratech.vente.dao.ifaces.operations.RetourClientDAORemote;
import com.teratech.vente.model.operations.RetourClient;

@Stateless(mappedName = "RetourClientDAO")
public class RetourClientDAOImpl
    extends AbstractGenericDAO<RetourClient, Long>
    implements RetourClientDAOLocal, RetourClientDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public RetourClientDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RetourClient> getManagedEntityClass() {
        return (RetourClient.class);
    }

}
