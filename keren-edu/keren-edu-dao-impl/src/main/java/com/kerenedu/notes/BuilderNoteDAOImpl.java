
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BuilderNoteDAO")
public class BuilderNoteDAOImpl
    extends AbstractGenericDAO<BuilderNote, Long>
    implements BuilderNoteDAOLocal, BuilderNoteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BuilderNoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BuilderNote> getManagedEntityClass() {
        return (BuilderNote.class);
    }

}
