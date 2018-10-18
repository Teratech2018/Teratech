
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PeriodePaieOpenDAO")
public class PeriodePaieOpenDAOImpl
    extends AbstractGenericDAO<PeriodePaieOpen, Long>
    implements PeriodePaieOpenDAOLocal, PeriodePaieOpenDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PeriodePaieOpenDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaieOpen> getManagedEntityClass() {
        return (PeriodePaieOpen.class);
    }

}
