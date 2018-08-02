
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RappelEDAO")
public class RappelEDAOImpl
    extends AbstractGenericDAO<RappelE, Long>
    implements RappelEDAOLocal, RappelEDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RappelEDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RappelE> getManagedEntityClass() {
        return (RappelE.class);
    }

}
