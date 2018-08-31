
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RecetteDAO")
public class RecetteDAOImpl
    extends AbstractGenericDAO<Recette, Long>
    implements RecetteDAOLocal, RecetteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RecetteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Recette> getManagedEntityClass() {
        return (Recette.class);
    }

}
