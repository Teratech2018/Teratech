
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ResponsabiliteDAO")
public class ResponsabiliteDAOImpl
    extends AbstractGenericDAO<Responsabilite, Long>
    implements ResponsabiliteDAOLocal, ResponsabiliteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ResponsabiliteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Responsabilite> getManagedEntityClass() {
        return (Responsabilite.class);
    }

}
