
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "DepenseDAO")
public class DepenseDAOImpl
    extends AbstractGenericDAO<Depense, Long>
    implements DepenseDAOLocal, DepenseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DepenseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Depense> getManagedEntityClass() {
        return (Depense.class);
    }

}
