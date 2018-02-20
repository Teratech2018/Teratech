
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TrancheHoraireCoursDAO")
public class TrancheHoraireCoursDAOImpl
    extends AbstractGenericDAO<TrancheHoraireCours, Long>
    implements TrancheHoraireCoursDAOLocal, TrancheHoraireCoursDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TrancheHoraireCoursDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TrancheHoraireCours> getManagedEntityClass() {
        return (TrancheHoraireCours.class);
    }

}
