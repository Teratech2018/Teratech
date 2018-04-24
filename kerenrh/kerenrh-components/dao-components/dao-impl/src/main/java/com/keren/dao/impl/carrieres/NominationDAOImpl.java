
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.NominationDAOLocal;
import com.keren.dao.ifaces.carrieres.NominationDAORemote;
import com.keren.model.carrieres.Nomination;

@Stateless(mappedName = "NominationDAO")
public class NominationDAOImpl
    extends AbstractGenericDAO<Nomination, Long>
    implements NominationDAOLocal, NominationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NominationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Nomination> getManagedEntityClass() {
        return (Nomination.class);
    }

}
