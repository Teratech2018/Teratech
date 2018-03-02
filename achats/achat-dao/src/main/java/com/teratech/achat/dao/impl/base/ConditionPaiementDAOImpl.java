
package com.teratech.achat.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.base.ConditionPaiementDAOLocal;
import com.teratech.achat.dao.ifaces.base.ConditionPaiementDAORemote;
import com.teratech.achat.model.base.ConditionPaiement;

@Stateless(mappedName = "ConditionPaiementDAO")
public class ConditionPaiementDAOImpl
    extends AbstractGenericDAO<ConditionPaiement, Long>
    implements ConditionPaiementDAOLocal, ConditionPaiementDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public ConditionPaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConditionPaiement> getManagedEntityClass() {
        return (ConditionPaiement.class);
    }

}
