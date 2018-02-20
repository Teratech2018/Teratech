
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "GroupeCoursDAO")
public class GroupeCoursDAOImpl
    extends AbstractGenericDAO<GroupeCours, Long>
    implements GroupeCoursDAOLocal, GroupeCoursDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public GroupeCoursDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<GroupeCours> getManagedEntityClass() {
        return (GroupeCours.class);
    }

}
