
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EmargementPeriodeDAO")
public class EmargementPeriodeDAOImpl
    extends AbstractGenericDAO<EmargementPeriode, Long>
    implements EmargementPeriodeDAOLocal, EmargementPeriodeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmargementPeriodeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EmargementPeriode> getManagedEntityClass() {
        return (EmargementPeriode.class);
    }

}
