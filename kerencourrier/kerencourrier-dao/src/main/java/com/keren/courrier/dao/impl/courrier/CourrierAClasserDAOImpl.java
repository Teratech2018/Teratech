
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierAClasserDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierAClasserDAORemote;
import com.keren.courrier.model.courrier.CourrierAClasser;

@Stateless(mappedName = "CourrierAClasserDAO")
public class CourrierAClasserDAOImpl
    extends AbstractGenericDAO<CourrierAClasser, Long>
    implements CourrierAClasserDAOLocal, CourrierAClasserDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierAClasserDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierAClasser> getManagedEntityClass() {
        return (CourrierAClasser.class);
    }

}
