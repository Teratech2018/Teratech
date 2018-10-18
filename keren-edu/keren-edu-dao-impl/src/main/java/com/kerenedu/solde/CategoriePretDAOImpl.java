
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CategoriePretDAO")
public class CategoriePretDAOImpl
    extends AbstractGenericDAO<CategoriePret, Long>
    implements CategoriePretDAOLocal, CategoriePretDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CategoriePretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CategoriePret> getManagedEntityClass() {
        return (CategoriePret.class);
    }

}
