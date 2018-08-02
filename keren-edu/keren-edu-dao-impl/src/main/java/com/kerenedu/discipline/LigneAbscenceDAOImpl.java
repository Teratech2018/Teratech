
package com.kerenedu.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneAbscenceDAO")
public class LigneAbscenceDAOImpl
    extends AbstractGenericDAO<LigneAbscence, Long>
    implements LigneAbscenceDAOLocal, LigneAbscenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneAbscenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneAbscence> getManagedEntityClass() {
        return (LigneAbscence.class);
    }

}
