
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierTrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierTrierDAORemote;
import com.keren.courrier.model.courrier.CourrierTrier;

@Stateless(mappedName = "CourrierTrierDAO")
public class CourrierTrierDAOImpl
    extends AbstractGenericDAO<CourrierTrier, Long>
    implements CourrierTrierDAOLocal, CourrierTrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierTrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierTrier> getManagedEntityClass() {
        return (CourrierTrier.class);
    }

}
