
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ClasseCycleDAO")
public class ClasseCycleDAOImpl
    extends AbstractGenericDAO<ClasseCycle, Long>
    implements ClasseCycleDAOLocal, ClasseCycleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ClasseCycleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ClasseCycle> getManagedEntityClass() {
        return (ClasseCycle.class);
    }

}
