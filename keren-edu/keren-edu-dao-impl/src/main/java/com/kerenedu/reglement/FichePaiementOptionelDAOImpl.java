
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FichePaiementOptionelDAO")
public class FichePaiementOptionelDAOImpl
    extends AbstractGenericDAO<FichePaiementOptionel, Long>
    implements FichePaiementOptionelDAOLocal, FichePaiementOptionelDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePaiementOptionelDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePaiementOptionel> getManagedEntityClass() {
        return (FichePaiementOptionel.class);
    }

}
