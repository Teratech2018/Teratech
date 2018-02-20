
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EleveDAO")
public class EleveDAOImpl
    extends AbstractGenericDAO<Eleve, Long>
    implements EleveDAOLocal, EleveDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EleveDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Eleve> getManagedEntityClass() {
        return (Eleve.class);
    }

}
