
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "StatistiqueNotesDAO")
public class StatistiqueNotesDAOImpl
    extends AbstractGenericDAO<StatistiqueNotes, Long>
    implements StatistiqueNotesDAOLocal, StatistiqueNotesDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public StatistiqueNotesDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<StatistiqueNotes> getManagedEntityClass() {
        return (StatistiqueNotes.class);
    }

}
