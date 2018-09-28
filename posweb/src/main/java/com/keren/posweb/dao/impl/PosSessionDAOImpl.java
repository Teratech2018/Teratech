
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.PosSessionDAOLocal;
import com.keren.posweb.dao.ifaces.PosSessionDAORemote;
import com.keren.posweb.model.PosSession;

@Stateless(mappedName = "PosSessionDAO")
public class PosSessionDAOImpl
    extends AbstractGenericDAO<PosSession, Long>
    implements PosSessionDAOLocal, PosSessionDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public PosSessionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PosSession> getManagedEntityClass() {
        return (PosSession.class);
    }

}
