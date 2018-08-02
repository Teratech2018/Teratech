
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierDAORemote;
import com.keren.courrier.model.courrier.Courrier;

@Stateless(mappedName = "CourrierDAO")
public class CourrierDAOImpl
    extends AbstractGenericDAO<Courrier, Long>
    implements CourrierDAOLocal, CourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Courrier> getManagedEntityClass() {
        return (Courrier.class);
    }

}
