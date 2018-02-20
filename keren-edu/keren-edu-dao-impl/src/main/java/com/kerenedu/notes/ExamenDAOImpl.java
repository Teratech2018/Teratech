
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ExamenDAO")
public class ExamenDAOImpl
    extends AbstractGenericDAO<Examen, Long>
    implements ExamenDAOLocal, ExamenDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ExamenDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Examen> getManagedEntityClass() {
        return (Examen.class);
    }

}
