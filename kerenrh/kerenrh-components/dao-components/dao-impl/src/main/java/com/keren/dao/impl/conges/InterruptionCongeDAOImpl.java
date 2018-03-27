
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.InterruptionCongeDAOLocal;
import com.keren.dao.ifaces.conges.InterruptionCongeDAORemote;
import com.keren.model.conges.InterruptionConge;

@Stateless(mappedName = "InterruptionCongeDAO")
public class InterruptionCongeDAOImpl
    extends AbstractGenericDAO<InterruptionConge, Long>
    implements InterruptionCongeDAOLocal, InterruptionCongeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public InterruptionCongeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<InterruptionConge> getManagedEntityClass() {
        return (InterruptionConge.class);
    }

}
