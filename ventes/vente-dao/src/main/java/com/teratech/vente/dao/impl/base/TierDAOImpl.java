
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.TierDAOLocal;
import com.teratech.vente.dao.ifaces.base.TierDAORemote;
import com.teratech.vente.model.base.Tier;

@Stateless(mappedName = "TierDAO")
public class TierDAOImpl
    extends AbstractGenericDAO<Tier, Long>
    implements TierDAOLocal, TierDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public TierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Tier> getManagedEntityClass() {
        return (Tier.class);
    }

}
