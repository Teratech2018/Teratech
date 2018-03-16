
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FichePaiementDAO")
public class FichePaiementDAOImpl
    extends AbstractGenericDAO<FichePaiement, Long>
    implements FichePaiementDAOLocal, FichePaiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePaiement> getManagedEntityClass() {
        return (FichePaiement.class);
    }

}
