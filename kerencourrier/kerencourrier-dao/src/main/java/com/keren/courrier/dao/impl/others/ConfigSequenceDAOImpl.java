
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.ConfigSequenceDAOLocal;
import com.keren.courrier.dao.ifaces.others.ConfigSequenceDAORemote;
import com.keren.courrier.model.others.ConfigSequence;

@Stateless(mappedName = "ConfigSequenceDAO")
public class ConfigSequenceDAOImpl
    extends AbstractGenericDAO<ConfigSequence, Long>
    implements ConfigSequenceDAOLocal, ConfigSequenceDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ConfigSequenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConfigSequence> getManagedEntityClass() {
        return (ConfigSequence.class);
    }

}
