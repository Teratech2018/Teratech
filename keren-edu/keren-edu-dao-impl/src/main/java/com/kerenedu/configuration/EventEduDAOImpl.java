
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EventEduDAO")
public class EventEduDAOImpl
    extends AbstractGenericDAO<EventEdu, Long>
    implements EventEduDAOLocal, EventEduDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EventEduDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EventEdu> getManagedEntityClass() {
        return (EventEdu.class);
    }

}
