
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierAAnnoteDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierAAnnoteDAORemote;
import com.keren.courrier.model.courrier.CourrierAAnnote;

@Stateless(mappedName = "CourrierAAnnoteDAO")
public class CourrierAAnnoteDAOImpl
    extends AbstractGenericDAO<CourrierAAnnote, Long>
    implements CourrierAAnnoteDAOLocal, CourrierAAnnoteDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierAAnnoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierAAnnote> getManagedEntityClass() {
        return (CourrierAAnnote.class);
    }

}
