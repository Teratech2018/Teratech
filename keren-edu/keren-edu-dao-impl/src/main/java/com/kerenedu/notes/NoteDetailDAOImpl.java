
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteDetailDAO")
public class NoteDetailDAOImpl
    extends AbstractGenericDAO<NoteDetail, Long>
    implements NoteDetailDAOLocal, NoteDetailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteDetailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteDetail> getManagedEntityClass() {
        return (NoteDetail.class);
    }

}
