
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.EventCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.EventCourrierDAORemote;
import com.keren.courrier.model.referentiel.EventCourrier;

@Stateless(mappedName = "EventCourrierDAO")
public class EventCourrierDAOImpl
    extends AbstractGenericDAO<EventCourrier, Long>
    implements EventCourrierDAOLocal, EventCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public EventCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EventCourrier> getManagedEntityClass() {
        return (EventCourrier.class);
    }

}
