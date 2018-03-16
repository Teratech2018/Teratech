
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PrimeProfDAO")
public class PrimeProfDAOImpl
    extends AbstractGenericDAO<PrimeProf, Long>
    implements PrimeProfDAOLocal, PrimeProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PrimeProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PrimeProf> getManagedEntityClass() {
        return (PrimeProf.class);
    }

}
