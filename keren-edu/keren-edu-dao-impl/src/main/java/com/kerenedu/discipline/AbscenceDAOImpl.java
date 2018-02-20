
package com.kerenedu.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AbscenceDAO")
public class AbscenceDAOImpl
    extends AbstractGenericDAO<Abscence, Long>
    implements AbscenceDAOLocal, AbscenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AbscenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Abscence> getManagedEntityClass() {
        return (Abscence.class);
    }

}
