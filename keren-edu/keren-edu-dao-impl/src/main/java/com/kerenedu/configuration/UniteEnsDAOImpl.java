
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "UniteEnsDAO")
public class UniteEnsDAOImpl
    extends AbstractGenericDAO<UniteEns, Long>
    implements UniteEnsDAOLocal, UniteEnsDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public UniteEnsDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UniteEns> getManagedEntityClass() {
        return (UniteEns.class);
    }

}
