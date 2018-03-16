
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PaiementDAO")
public class PaiementDAOImpl
    extends AbstractGenericDAO<Paiement, Long>
    implements PaiementDAOLocal, PaiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Paiement> getManagedEntityClass() {
        return (Paiement.class);
    }

}
