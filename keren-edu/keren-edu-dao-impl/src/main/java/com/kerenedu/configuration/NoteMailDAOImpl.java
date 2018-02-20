
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteMailDAO")
public class NoteMailDAOImpl
    extends AbstractGenericDAO<NoteMail, Long>
    implements NoteMailDAOLocal, NoteMailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteMailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteMail> getManagedEntityClass() {
        return (NoteMail.class);
    }

}
