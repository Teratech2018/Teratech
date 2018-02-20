
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "MatiereDAO")
public class MatiereDAOImpl
    extends AbstractGenericDAO<Matiere, Long>
    implements MatiereDAOLocal, MatiereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MatiereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Matiere> getManagedEntityClass() {
        return (Matiere.class);
    }

}
