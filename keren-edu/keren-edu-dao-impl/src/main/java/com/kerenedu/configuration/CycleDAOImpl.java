
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CycleDAO")
public class CycleDAOImpl
    extends AbstractGenericDAO<Cycle, Long>
    implements CycleDAOLocal, CycleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CycleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Cycle> getManagedEntityClass() {
        return (Cycle.class);
    }

}
