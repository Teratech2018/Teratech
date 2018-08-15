
package com.core.templates;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ThemeRecordDAO")
public class ThemeRecordDAOImpl
    extends AbstractGenericDAO<ThemeRecord, Long>
    implements ThemeRecordDAOLocal, ThemeRecordDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ThemeRecordDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ThemeRecord> getManagedEntityClass() {
        return (ThemeRecord.class);
    }

}
