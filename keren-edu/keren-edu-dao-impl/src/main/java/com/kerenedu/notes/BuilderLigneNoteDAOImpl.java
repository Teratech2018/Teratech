
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BuilderLigneNoteDAO")
public class BuilderLigneNoteDAOImpl
    extends AbstractGenericDAO<BuilderLigneNote, Long>
    implements BuilderLigneNoteDAOLocal, BuilderLigneNoteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BuilderLigneNoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BuilderLigneNote> getManagedEntityClass() {
        return (BuilderLigneNote.class);
    }

}
