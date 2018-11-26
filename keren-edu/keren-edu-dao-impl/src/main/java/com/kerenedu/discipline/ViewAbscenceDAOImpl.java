
package com.kerenedu.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ViewAbscenceDAO")
public class ViewAbscenceDAOImpl
    extends AbstractGenericDAO<ViewAbscence, Long>
    implements ViewAbscenceDAOLocal, ViewAbscenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewAbscenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewAbscence> getManagedEntityClass() {
        return (ViewAbscence.class);
    }

}
