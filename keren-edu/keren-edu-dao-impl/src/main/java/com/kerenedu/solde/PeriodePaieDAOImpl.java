
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PeriodePaieDAO")
public class PeriodePaieDAOImpl
    extends AbstractGenericDAO<PeriodePaie, Long>
    implements PeriodePaieDAOLocal, PeriodePaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PeriodePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaie> getManagedEntityClass() {
        return (PeriodePaie.class);
    }

}
