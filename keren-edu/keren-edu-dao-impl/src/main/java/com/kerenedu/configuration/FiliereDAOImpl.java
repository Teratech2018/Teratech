
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FiliereDAO")
public class FiliereDAOImpl
    extends AbstractGenericDAO<Filiere, Long>
    implements FiliereDAOLocal, FiliereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FiliereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Filiere> getManagedEntityClass() {
        return (Filiere.class);
    }

}
