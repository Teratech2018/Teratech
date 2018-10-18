
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PeriodePaieCloseDAO")
public class PeriodePaieCloseDAOImpl
    extends AbstractGenericDAO<PeriodePaieClose, Long>
    implements PeriodePaieCloseDAOLocal, PeriodePaieCloseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PeriodePaieCloseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaieClose> getManagedEntityClass() {
        return (PeriodePaieClose.class);
    }

}
