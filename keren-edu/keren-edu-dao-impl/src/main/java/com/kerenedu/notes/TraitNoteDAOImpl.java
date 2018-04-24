
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TraitNoteDAO")
public class TraitNoteDAOImpl
    extends AbstractGenericDAO<TraitNote, Long>
    implements TraitNoteDAOLocal, TraitNoteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TraitNoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitNote> getManagedEntityClass() {
        return (TraitNote.class);
    }

}
