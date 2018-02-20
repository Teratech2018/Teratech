
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PlanifCoursDAO")
public class PlanifCoursDAOImpl
    extends AbstractGenericDAO<PlanifCours, Long>
    implements PlanifCoursDAOLocal, PlanifCoursDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PlanifCoursDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PlanifCours> getManagedEntityClass() {
        return (PlanifCours.class);
    }

}
