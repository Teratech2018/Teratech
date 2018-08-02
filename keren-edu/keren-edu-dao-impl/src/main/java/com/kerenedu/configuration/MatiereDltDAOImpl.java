
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "MatiereDltDAO")
public class MatiereDltDAOImpl
    extends AbstractGenericDAO<MatiereDlt, Long>
    implements MatiereDltDAOLocal, MatiereDltDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MatiereDltDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MatiereDlt> getManagedEntityClass() {
        return (MatiereDlt.class);
    }

}
