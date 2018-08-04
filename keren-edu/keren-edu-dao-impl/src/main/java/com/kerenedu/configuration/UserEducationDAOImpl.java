
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "UserEducationDAO")
public class UserEducationDAOImpl
    extends AbstractGenericDAO<UserEducation, Long>
    implements UserEducationDAOLocal, UserEducationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public UserEducationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UserEducation> getManagedEntityClass() {
        return (UserEducation.class);
    }

}
