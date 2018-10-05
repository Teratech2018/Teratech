
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.PortionSequenceDAOLocal;
import com.keren.courrier.dao.ifaces.others.PortionSequenceDAORemote;
import com.keren.courrier.model.others.PortionSequence;

@Stateless(mappedName = "PortionSequenceDAO")
public class PortionSequenceDAOImpl
    extends AbstractGenericDAO<PortionSequence, Long>
    implements PortionSequenceDAOLocal, PortionSequenceDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public PortionSequenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PortionSequence> getManagedEntityClass() {
        return (PortionSequence.class);
    }

}
