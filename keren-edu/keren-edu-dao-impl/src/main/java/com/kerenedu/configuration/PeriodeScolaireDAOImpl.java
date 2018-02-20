
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PeriodeScolaireDAO")
public class PeriodeScolaireDAOImpl
    extends AbstractGenericDAO<PeriodeScolaire, Long>
    implements PeriodeScolaireDAOLocal, PeriodeScolaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PeriodeScolaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodeScolaire> getManagedEntityClass() {
        return (PeriodeScolaire.class);
    }

}
