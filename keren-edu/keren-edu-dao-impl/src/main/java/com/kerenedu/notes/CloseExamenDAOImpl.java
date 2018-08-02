
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CloseExamenDAO")
public class CloseExamenDAOImpl
    extends AbstractGenericDAO<CloseExamen, Long>
    implements CloseExamenDAOLocal, CloseExamenDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CloseExamenDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CloseExamen> getManagedEntityClass() {
        return (CloseExamen.class);
    }

}
