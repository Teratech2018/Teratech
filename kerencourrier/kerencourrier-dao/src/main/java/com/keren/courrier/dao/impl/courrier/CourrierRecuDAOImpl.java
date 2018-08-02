
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierRecuDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierRecuDAORemote;
import com.keren.courrier.model.courrier.CourrierRecu;

@Stateless(mappedName = "CourrierRecuDAO")
public class CourrierRecuDAOImpl
    extends AbstractGenericDAO<CourrierRecu, Long>
    implements CourrierRecuDAOLocal, CourrierRecuDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierRecuDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierRecu> getManagedEntityClass() {
        return (CourrierRecu.class);
    }

}
