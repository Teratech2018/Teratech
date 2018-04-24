
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.ParticipantSeanceDAOLocal;
import com.keren.dao.ifaces.formations.ParticipantSeanceDAORemote;
import com.keren.model.formations.ParticipantSeance;

@Stateless(mappedName = "ParticipantSeanceDAO")
public class ParticipantSeanceDAOImpl
    extends AbstractGenericDAO<ParticipantSeance, Long>
    implements ParticipantSeanceDAOLocal, ParticipantSeanceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ParticipantSeanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ParticipantSeance> getManagedEntityClass() {
        return (ParticipantSeance.class);
    }

}
