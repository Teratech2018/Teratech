
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.TiroirArchivageDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.TiroirArchivageDAORemote;
import com.keren.courrier.model.archivage.TiroirArchivage;

@Stateless(mappedName = "TiroirArchivageDAO")
public class TiroirArchivageDAOImpl
    extends AbstractGenericDAO<TiroirArchivage, Long>
    implements TiroirArchivageDAOLocal, TiroirArchivageDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public TiroirArchivageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TiroirArchivage> getManagedEntityClass() {
        return (TiroirArchivage.class);
    }

}
