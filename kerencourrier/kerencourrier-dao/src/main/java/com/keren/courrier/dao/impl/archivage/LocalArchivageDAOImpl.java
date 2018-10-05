
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.LocalArchivageDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LocalArchivageDAORemote;
import com.keren.courrier.model.archivage.LocalArchivage;

@Stateless(mappedName = "LocalArchivageDAO")
public class LocalArchivageDAOImpl
    extends AbstractGenericDAO<LocalArchivage, Long>
    implements LocalArchivageDAOLocal, LocalArchivageDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LocalArchivageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LocalArchivage> getManagedEntityClass() {
        return (LocalArchivage.class);
    }

}
