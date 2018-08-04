
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierTousDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierTousDAORemote;
import com.keren.courrier.model.courrier.CourrierTous;

@Stateless(mappedName = "CourrierTousDAO")
public class CourrierTousDAOImpl
    extends AbstractGenericDAO<CourrierTous, Long>
    implements CourrierTousDAOLocal, CourrierTousDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierTousDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierTous> getManagedEntityClass() {
        return (CourrierTous.class);
    }

}
