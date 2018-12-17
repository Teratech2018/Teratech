
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EmargementDtlPeriodeDAO")
public class EmargementDtlPeriodeDAOImpl
    extends AbstractGenericDAO<EmargementDtlPeriode, Long>
    implements EmargementDtlPeriodeDAOLocal, EmargementDtlPeriodeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmargementDtlPeriodeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EmargementDtlPeriode> getManagedEntityClass() {
        return (EmargementDtlPeriode.class);
    }

}
