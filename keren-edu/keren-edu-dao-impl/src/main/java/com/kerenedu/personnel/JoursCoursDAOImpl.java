
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "JoursCoursDAO")
public class JoursCoursDAOImpl
    extends AbstractGenericDAO<JoursCours, Long>
    implements JoursCoursDAOLocal, JoursCoursDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public JoursCoursDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<JoursCours> getManagedEntityClass() {
        return (JoursCours.class);
    }

}
