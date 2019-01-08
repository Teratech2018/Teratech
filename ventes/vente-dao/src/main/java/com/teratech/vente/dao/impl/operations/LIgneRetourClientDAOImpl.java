
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.LIgneRetourClientDAOLocal;
import com.teratech.vente.dao.ifaces.operations.LIgneRetourClientDAORemote;
import com.teratech.vente.model.operations.LIgneRetourClient;

@Stateless(mappedName = "LIgneRetourClientDAO")
public class LIgneRetourClientDAOImpl
    extends AbstractGenericDAO<LIgneRetourClient, Long>
    implements LIgneRetourClientDAOLocal, LIgneRetourClientDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public LIgneRetourClientDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LIgneRetourClient> getManagedEntityClass() {
        return (LIgneRetourClient.class);
    }

}
