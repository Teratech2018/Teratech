
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ResponsableDAO")
public class ResponsableDAOImpl
    extends AbstractGenericDAO<Responsable, Long>
    implements ResponsableDAOLocal, ResponsableDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ResponsableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Responsable> getManagedEntityClass() {
        return (Responsable.class);
    }

}
