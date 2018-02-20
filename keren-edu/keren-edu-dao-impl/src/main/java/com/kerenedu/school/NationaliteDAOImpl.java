
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NationaliteDAO")
public class NationaliteDAOImpl
    extends AbstractGenericDAO<Nationalite, Long>
    implements NationaliteDAOLocal, NationaliteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NationaliteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Nationalite> getManagedEntityClass() {
        return (Nationalite.class);
    }

}
