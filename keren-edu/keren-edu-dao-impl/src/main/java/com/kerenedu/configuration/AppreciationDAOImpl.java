
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AppreciationDAO")
public class AppreciationDAOImpl
    extends AbstractGenericDAO<Appreciation, Long>
    implements AppreciationDAOLocal, AppreciationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AppreciationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Appreciation> getManagedEntityClass() {
        return (Appreciation.class);
    }

}
