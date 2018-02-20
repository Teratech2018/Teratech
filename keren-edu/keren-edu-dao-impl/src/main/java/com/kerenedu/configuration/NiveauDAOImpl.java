
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NiveauDAO")
public class NiveauDAOImpl
    extends AbstractGenericDAO<Niveau, Long>
    implements NiveauDAOLocal, NiveauDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NiveauDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Niveau> getManagedEntityClass() {
        return (Niveau.class);
    }

}
