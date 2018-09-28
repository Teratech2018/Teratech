
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FichePaiementRetardDAO")
public class FichePaiementRetardDAOImpl
    extends AbstractGenericDAO<FichePaiementRetard, Long>
    implements FichePaiementRetardDAOLocal, FichePaiementRetardDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePaiementRetardDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePaiementRetard> getManagedEntityClass() {
        return (FichePaiementRetard.class);
    }

}
