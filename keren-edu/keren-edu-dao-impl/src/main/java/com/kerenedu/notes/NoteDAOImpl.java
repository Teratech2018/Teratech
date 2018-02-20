
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteDAO")
public class NoteDAOImpl
    extends AbstractGenericDAO<Note, Long>
    implements NoteDAOLocal, NoteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Note> getManagedEntityClass() {
        return (Note.class);
    }

}
