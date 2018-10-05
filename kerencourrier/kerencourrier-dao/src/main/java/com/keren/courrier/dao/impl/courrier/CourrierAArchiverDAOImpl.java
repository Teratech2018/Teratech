
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierAArchiverDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierAArchiverDAORemote;
import com.keren.courrier.model.courrier.CourrierAArchiver;

@Stateless(mappedName = "CourrierAArchiverDAO")
public class CourrierAArchiverDAOImpl
    extends AbstractGenericDAO<CourrierAArchiver, Long>
    implements CourrierAArchiverDAOLocal, CourrierAArchiverDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierAArchiverDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierAArchiver> getManagedEntityClass() {
        return (CourrierAArchiver.class);
    }

}
