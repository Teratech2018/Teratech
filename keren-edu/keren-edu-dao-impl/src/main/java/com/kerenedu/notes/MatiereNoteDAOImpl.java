
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "MatiereNoteDAO")
public class MatiereNoteDAOImpl
    extends AbstractGenericDAO<MatiereNote, Long>
    implements MatiereNoteDAOLocal, MatiereNoteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MatiereNoteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MatiereNote> getManagedEntityClass() {
        return (MatiereNote.class);
    }

}
