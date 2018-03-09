
package com.kerenedu.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PresenceDAO")
public class PresenceDAOImpl
    extends AbstractGenericDAO<Presence, Long>
    implements PresenceDAOLocal, PresenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PresenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Presence> getManagedEntityClass() {
        return (Presence.class);
    }

}
