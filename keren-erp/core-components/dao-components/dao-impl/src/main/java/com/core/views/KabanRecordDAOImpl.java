
package com.core.views;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "KabanRecordDAO")
public class KabanRecordDAOImpl
    extends AbstractGenericDAO<KabanRecord, Long>
    implements KabanRecordDAOLocal, KabanRecordDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public KabanRecordDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<KabanRecord> getManagedEntityClass() {
        return (KabanRecord.class);
    }

}
